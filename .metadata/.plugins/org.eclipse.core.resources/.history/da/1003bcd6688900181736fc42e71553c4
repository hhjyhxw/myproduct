package zhumeng.com.uimei.web.wxserver.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.util.ClassUtils;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;
import zhumeng.com.uimei.web.wxserver.entity.menu.BaseMenu;

public class MenuConstUtil {

	   
	   private static Map<String,String> map = new HashMap<String,String>();
	   //1视图2事件3扫码（显示结果）或者跳转链接 4跳转小程序,5扫码，有提示框，可以接受开发者推送的消息
	   static{
		   map.put("1", "com.gxnnbsd.charger.wx.entity.menu.UrlMenu");//view
		   map.put("2", "com.gxnnbsd.charger.wx.entity.menu.ClickMenu");//事件
		   map.put("3", "com.gxnnbsd.charger.wx.entity.menu.ScancodeMenu");//扫码（显示结果）或者跳转链接
		   map.put("4", "com.gxnnbsd.charger.wx.entity.menu.XcxMenu");//跳转小程序
		   map.put("5", "com.gxnnbsd.charger.wx.entity.menu.ScancodeWaitmsg");//扫码，有提示框，可以接受开发者推送的消息
	   }
	   //根据数据存储菜单对象获取微信菜单
	 @SuppressWarnings("unused")
	public static BaseMenu getWxMenu(TWxMenu wxMenu){
		  
		  Class<BaseMenu> zlass =  ClassUtils.forName(map.get(wxMenu.getMenuType().toString()));
		  Constructor<BaseMenu> c;
		  BaseMenu baseMenu = null;
		try {
			c = zlass.getConstructor(TWxMenu.class);
			baseMenu = c.newInstance(wxMenu);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取有参构造
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseMenu;
	   }
	   
}
