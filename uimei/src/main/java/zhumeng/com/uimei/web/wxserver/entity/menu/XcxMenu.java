package zhumeng.com.uimei.web.wxserver.entity.menu;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;

public class XcxMenu extends BaseMenu {
	
	private String type = "miniprogram";//菜单类型
	private String appid;       //小程序appid  
	private String pagepath;    //小程序页面路径  
	private String url;    //跳转链接

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public XcxMenu(){
	}
	public XcxMenu(TWxMenu wxMenu){
		super(wxMenu);
		this.appid = wxMenu.getXcxAppid();
		this.pagepath = wxMenu.getPagepath();
		this.url = wxMenu.getUrl();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
