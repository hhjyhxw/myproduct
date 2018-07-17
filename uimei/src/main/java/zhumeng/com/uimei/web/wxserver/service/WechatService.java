//package com.gxnnbsd.charger.wx.service;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.gxnnbsd.charger.wx.util.MessageUtil;
//import com.gxnnbsd.modules.business.wx.entity.TWxApp;
//import com.gxnnbsd.modules.business.wx.service.WxAppService;
//
//@Service
//public class WechatService {
//
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	@Resource
//	private MessageHandler messageHandler;
//	//工作号表
//	@Resource
//	private WxAppService wxAppService;
//	/**
//     * 处理微信发来的请求
//     * @param request
//     * @return
//     */
//    public String weixinPost(HttpServletRequest request) {
//        String respMessage = null;
//        try {
//            // xml请求解析
//            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
//            // 发送方帐号（open_id）
//            String fromUserName = requestMap.get("FromUserName");
//            // 公众帐号
//            String toUserName = requestMap.get("ToUserName");
//            // 消息类型
//            String msgType = requestMap.get("MsgType");
//            // 消息内容
//            logger.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);
//            
//            //查找微信号
//            TWxApp tWxApp= new TWxApp();
//            tWxApp.setAccountNumber(toUserName);
//            List<TWxApp> list = wxAppService.findList(tWxApp);
//            if(list!=null && list.size()>0){
//            	tWxApp = list.get(0);
//            }else{
//            	return null;
//            }
//            //1、文本消息
//            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//            	logger.info("请求消息类型：文本 ");
//            	return messageHandler.dealText(requestMap.get("Content"),fromUserName,toUserName,tWxApp.getId());
//            }
//            //2、事件推送
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//            	logger.info("请求消息类型：事件推送  ");
//                String eventType = requestMap.get("Event");// 事件类型
//                // 订阅
//                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//                	return messageHandler.dealSubscribe(fromUserName,toUserName,tWxApp.getId());
//                } 
//                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅
//                	return messageHandler.dealUnSubscribe(fromUserName,toUserName);
//                } 
//                // 自定义菜单点击事件
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//                	return messageHandler.dealMenuClick(requestMap.get("EventKey"),fromUserName,toUserName,tWxApp.getId());
//                }
//            //3、事其他所有 给 默认回复
//            }else{
//            	//return messageHandler.dealDefault(fromUserName,toUserName,tWxApp.getId());
//            }
//        }
//        catch (Exception e) {
//        	logger.error("error......");
//        }
//        return respMessage;
//    }
//}
