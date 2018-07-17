package zhumeng.com.uimei.web.wxserver.util;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import zhumeng.com.uimei.common.ConfigUtil;
import zhumeng.com.uimei.common.HttpClientUtils;
import zhumeng.com.uimei.web.wxserver.entity.menu.Menu;



public class WeixinUtil {
	private final static Log log = LogFactory.getLog(WeixinUtil.class);

	/**
	 * 创建json菜单字符串并发布至微信服务器
	 * 
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = ConfigUtil.get("menu_create_url").replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSON.toJSONString(menu);
		log.info(jsonMenu);
		// 调用接口创建菜单
		JSONObject jsonObject =  HttpClientUtils.httpsRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getIntValue("errcode")) {
				result = jsonObject.getIntValue("errcode");
				log.error("创建菜单失败 errcode:{" + jsonObject.getIntValue("errcode")+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
			}
		}
		return result; // 创建成功
	}

	/**
	 * 删除自定义菜单
	 * @param accessToken
	 * @return
	 */
	public static int deleteMenu(String accessToken) {
		String url = ConfigUtil.get("menu_delete_url").replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject =  HttpClientUtils.httpsRequest(url, "GET", null);
		return jsonObject.getIntValue("errcode");

	}
	
	/** 客服接口
	 * @Title: customSend 
	 * @Description: TODO
	 * @param openid
	 * @param message
	 * @param accessToken
	 * @return
	 * @return: JSONObject
	 */
	public static JSONObject customSend(String openid,String message,String accessToken){
		String url = ConfigUtil.get("custom_send").replace("ACCESS_TOKEN", accessToken);		
		JSONObject json =new JSONObject();
		json.put("touser", openid);
		json.put("msgtype", "text");
		JSONObject content =new JSONObject();
		content.put("content", message);
		json.put("text",content);
		JSONObject jsonObject =  HttpClientUtils.httpsRequest(url, "POST", json.toString());
		return jsonObject;
	}
	
	public static JSONObject templateSend(String openid,String template_id,Map<String,String> miniprogram,JSONObject data,String accessToken){
		String url =  ConfigUtil.get("template_send").replace("ACCESS_TOKEN", accessToken);
		JSONObject json =new JSONObject();
		json.put("touser", openid);
		json.put("template_id", template_id);
		json.put("data", data);
		if(miniprogram!=null){
			json.put("miniprogram", miniprogram);
		}
		
		JSONObject jsonObject =  HttpClientUtils.httpsRequest(url, "POST", json.toString());
		return jsonObject;
		
	}
}