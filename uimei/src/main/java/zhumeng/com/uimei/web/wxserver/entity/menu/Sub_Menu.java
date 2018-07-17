package zhumeng.com.uimei.web.wxserver.entity.menu;

import java.util.ArrayList;
import java.util.List;




public class Sub_Menu extends BaseMenu  {
	
	
	public Sub_Menu() {

	}

	private List<BaseMenu> sub_button = new ArrayList<BaseMenu>();

	public List<BaseMenu> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<BaseMenu> sub_button) {
		this.sub_button = sub_button;
	}

	
	

}
