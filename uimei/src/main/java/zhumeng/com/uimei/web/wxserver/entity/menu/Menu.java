package zhumeng.com.uimei.web.wxserver.entity.menu;

import java.util.ArrayList;
import java.util.List;


public class Menu {
	private List<BaseMenu> button = new ArrayList<BaseMenu>();

	
	public List<BaseMenu> getButton() {
		return button;
	}

	public void setButton(List<BaseMenu> button) {
		this.button = button;
	}
}
