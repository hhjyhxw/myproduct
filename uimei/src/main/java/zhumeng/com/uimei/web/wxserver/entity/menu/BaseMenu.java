package zhumeng.com.uimei.web.wxserver.entity.menu;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;

public class BaseMenu {
	
	private String name;
	
	
	
	public BaseMenu(TWxMenu wxMenu) {
		this.name=wxMenu.getName();
	}

	public BaseMenu() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
}
