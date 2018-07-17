package zhumeng.com.uimei.web.wxserver.entity.menu;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;

public class ScancodeWaitmsg extends BaseMenu {
	private String type = "scancode_waitmsg";
	private String key;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public ScancodeWaitmsg(){
	}
	public ScancodeWaitmsg(TWxMenu wxMenu){
		super(wxMenu);
		this.key = wxMenu.getId().toString();
	}
}
