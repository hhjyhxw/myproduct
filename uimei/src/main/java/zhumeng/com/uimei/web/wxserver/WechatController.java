package zhumeng.com.uimei.web.wxserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zhumeng.com.uimei.service.wx.TWxAppService;
import zhumeng.com.uimei.web.wxserver.service.WechatService;
import zhumeng.com.uimei.web.wxserver.util.SignUtil;


/**
 * 接入微信服务器
 * @author z
 *
 */
@Controller
@RequestMapping(value = "/weixinserver/weixin")
public class WechatController {

	    public String token="zhumeng";//这个需要配成统一的token
	    
	    private Logger logger = LoggerFactory.getLogger(getClass());
	    
	    @Resource
	    private WechatService wechatService;
	    
	   //工众号表
		@Resource
		private TWxAppService wxAppService;
	    
	    
	    @RequestMapping(value="/connect",method = {RequestMethod.GET, RequestMethod.POST})
	    @ResponseBody
	    public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException{
	        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
	        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
	        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
	        boolean isGet = request.getMethod().toLowerCase().equals("get"); 
	        PrintWriter out = response.getWriter();
//	        TWxApp wxApp = wxAppService.getWxApp(request);	        
	        try {
	            if (isGet) {
	                String signature = request.getParameter("signature");// 微信加密签名  
	                String timestamp = request.getParameter("timestamp");// 时间戳  
	                String nonce = request.getParameter("nonce");// 随机数  
	                String echostr = request.getParameter("echostr");//随机字符串  
	                
	                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
	                if (SignUtil.checkSignature(token, signature, timestamp, nonce)) {  
	                	logger.info("Connect the weixin server is successful.");
	                    response.getWriter().write(echostr);  
	                } else {  
	                	logger.error("Failed to verify the signature!"); 
	                }
	            }else{
	                String respMessage = "异常消息！";
	                try {
	                    respMessage = wechatService.weixinPost(request);
	                    if(respMessage!=null){
	                    	 out.write(respMessage);
	                    }
	                    logger.info("The request completed successfully");
	                    logger.info("to weixin server "+respMessage);
	                } catch (Exception e) {
	                	logger.error("Failed to convert the message from weixin!"); 
	                }
	                
	            }
	        } catch (Exception e) {
	        	logger.error("Connect the weixin server is error.");
	        }finally{
	            out.close();
	        }
	    }
}
