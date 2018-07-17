package zhumeng.com.uimei.service.wx.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;
import zhumeng.com.uimei.model.dbo.wx.TWxReply;
import zhumeng.com.uimei.service.wx.TWxImageTextService;
import zhumeng.com.uimei.service.wx.TWxMenuService;
import zhumeng.com.uimei.service.wx.TWxReplyService;

/**
 * @Title: WxMenuAndwxReplyAndwxImageTextService.java
 * @Package zhumeng.com.uimei.service.wx.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月16日
 * @version V1.0
 */
@Service
@Transactional
public class WxMenuAndwxReplyAndwxImageTextService {
	
	@Autowired
	private TWxMenuService wxMenuService;
	@Autowired
	private TWxReplyService wxReplyService;
	@Autowired
	private TWxImageTextService wxImageTextService;
	
	/**
	 * 宝成菜单 和菜单 关联的回复
	 * @param tWxMenu
	 * @param wxReply
	 * @throws Exception 
	 */
	@Transactional
	public void saveWxMenuAndWxReply(TWxMenu tWxMenu, TWxReply wxReply) throws Exception {
		wxMenuService.save(tWxMenu);
		wxReply.setMsgKey(tWxMenu.getId().toString());
		wxReplyService.save(wxReply);
	}

}
