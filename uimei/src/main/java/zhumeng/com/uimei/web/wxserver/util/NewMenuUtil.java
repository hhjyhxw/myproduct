package zhumeng.com.uimei.web.wxserver.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;
import zhumeng.com.uimei.web.wxserver.entity.menu.BaseMenu;
import zhumeng.com.uimei.web.wxserver.entity.menu.Menu;
import zhumeng.com.uimei.web.wxserver.entity.menu.Sub_Menu;

import com.alibaba.fastjson.JSON;

public class NewMenuUtil {
	
	/**
	 * 生成微信菜单 通过菜单列表生成微信菜单
	 * 
	 * @param menus
	 * @return
	 */
	public static Menu getMenu(List<TWxMenu> menus) {
		List<TWxMenu> parentList = new ArrayList<TWxMenu>();
		//一级菜单
		for (int i = 0; i < menus.size(); i++) {
			TWxMenu m = menus.get(i);
			if (m.getMenuLevel().intValue() == 1) { // 一级菜单
				parentList.add(m);
				menus.remove(i);
				i--;
			}
		}
		//获取二级菜单 并封装到一级
		for (TWxMenu son : menus) {
			int index = parentList.indexOf(son.getParent());
			if(index>=0){
				TWxMenu parent = parentList.get(index);
				if(parent.getChildrenList()!=null){
					parent.getChildrenList().add(son);
				}else{
					List<TWxMenu> sonList = new ArrayList<TWxMenu>();
					sonList.add(son);
					parent.setChildrenList(sonList);
				}
			}
		}
		//按排序
		sortTWxMenuAsc(parentList);
		//封装一级微信菜单
		Menu menu = new Menu();
		for (int i=0;i<parentList.size();i++) {
			TWxMenu localParenMenu = parentList.get(i);
			BaseMenu  parentMenu = MenuConstUtil.getWxMenu(localParenMenu);
			List<TWxMenu> childrenList = localParenMenu.getChildrenList();
			Sub_Menu sub = new Sub_Menu();
			if(childrenList!=null && childrenList.size()>0){
				sortTWxMenuDesc(childrenList);
				//封装二级微信菜单
				for (int j = 0; j < childrenList.size(); j++) {
					TWxMenu localSonMenu = childrenList.get(j);
					BaseMenu  wxSonMenu = MenuConstUtil.getWxMenu(localSonMenu);
					sub.getSub_button().add(wxSonMenu); 
					//二级菜单只能是最多5个
					if(j>=4){
						break;
					}
				}
			}
			//有二级菜单放集合，否则放一级菜单对象
			if(sub.getSub_button().size()>0){
				sub.setName(localParenMenu.getName());
				menu.getButton().add(sub);
			}else{
				menu.getButton().add(parentMenu);
			}
			//一级菜单只能是最多三个
			if(i>=2){
				break;
			}
		}
		System.out.println(JSON.toJSONString(menu));
		return menu;
	}

	   //按序号升级排列 (父菜单排序)序号越小越在左
	  // 使用 java 7 排序
	   private static void sortTWxMenuAsc(List<TWxMenu> list){   
	      Collections.sort(list, new Comparator<TWxMenu>() {
			@Override
			public int compare(TWxMenu o1, TWxMenu o2) {
				if(o1.getOrderNo().intValue()<o2.getOrderNo().intValue()){
					return -1;
				}else if(o1.getOrderNo().intValue()>o2.getOrderNo().intValue()){
					return 1;
				}
				return 0;
			}
	      });
	   }
	   
	   //按序降序排列 (子菜单排序) 序号越小越在下, 公众号菜单从下往上排序
	  // 使用 java 7 排序
	   private static void sortTWxMenuDesc(List<TWxMenu> list){   
	      Collections.sort(list, new Comparator<TWxMenu>() {
			@Override
			public int compare(TWxMenu o1, TWxMenu o2) {
				if(o1.getOrderNo().intValue()<o2.getOrderNo().intValue()){
					return 1;
				}else if(o1.getOrderNo().intValue()>o2.getOrderNo().intValue()){
					return -1;
				}
				return 0;
			}
	      });
	   }
}
