package zhumeng.com.uimei.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import zhumeng.com.uimei.common.ConfigUtil;
import zhumeng.com.uimei.common.DateUtils;
import zhumeng.com.uimei.common.DefaultKeyGenerator;
import zhumeng.com.uimei.common.IpUtil;
import zhumeng.com.uimei.kafka.KafkaProductServer;
import zhumeng.com.uimei.kafka.ProducerThreadPool;
import zhumeng.com.uimei.kafka.model.VisitLogs;
import zhumeng.com.uimei.model.bms.BmsAdmin;

/**
 * 权限拦截器
 *
 */
public class PermissionsInterceptor implements HandlerInterceptor {
	
	private static final ThreadLocal<Long> fronStartTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal fontStartTime");
	public static final String NO_INTERCEPTOR_PATH = ".*((_del)|(_getList)|(_input))";	//不对匹配该值的访问路径拦截（正则）
	
	public final static Logger log = LoggerFactory.getLogger(PermissionsInterceptor.class);
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
//		if (log.isDebugEnabled()){
			long startTime = System.currentTimeMillis();
			fronStartTimeThreadLocal.set(startTime);
			printlnVisitInfo(request,handler);
			
//		}
			
			Object obj = request.getSession().getAttribute("admin_user");
			
			 if("open".equals(ConfigUtil.get("open_logclient"))){
		 	    try{
		 		  logOnserver(request,handler,obj!=null?((BmsAdmin)obj).getAccount():"");
		 	    }catch(Exception e){
//		 	    	 e.printStackTrace();
		 	    	log.info(e.getMessage());
		 	    }
			 }
			
		if(null==obj){
			printlnVisitInfo(request,handler);
			response.sendRedirect("/tologin");
			return false;
		}
		
		return true;
	}


	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
	        Method method = handlerMethod.getMethod();
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		if(ex!=null){
			ex.printStackTrace();
		}
		 InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
		 String hostAddress = address.getHostAddress();//192.168.0.121
		 log.info("主机地址=="+hostAddress);
		// 打印JVM信息。
//		if (log.isDebugEnabled()){
			long beginTime = fronStartTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
			long endTime = System.currentTimeMillis(); 	//2、结束时间  
			log.info("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
	        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
			  //删除线程变量中的数据，防止内存泄漏
	        fronStartTimeThreadLocal.remove();
//		}
		
		
	}
	
	/**
	 * @Description: 打印日志
	 * @param        @param request
	 * @param        @param handler
	 * @param        @throws IOException    
	 * @return       void 
	 * @throws
	 * @author       z
	 * @datetime     2018年7月3日上午10:50:26
	 */
	private void printlnVisitInfo(HttpServletRequest request,Object handler) throws IOException{
		 // 所有请求第一个进入的方法  
        String reqURL = request.getRequestURL().toString();  
        String ip = IpUtil.getIpAddr(request);
        InputStream  is = request.getInputStream ();  
        StringBuilder responseStrBuilder = new StringBuilder ();  
        BufferedReader streamReader = new BufferedReader (new InputStreamReader (is,"UTF-8"));  
        String inputStr;  
         while ((inputStr = streamReader.readLine ()) != null)  
         responseStrBuilder.append (inputStr);  
         String parmeter = responseStrBuilder.toString();  
           
       long startTime = System.currentTimeMillis();  
       request.setAttribute("startTime", startTime);  
       if (handler instanceof HandlerMethod) {  
           StringBuilder sb = new StringBuilder(1000);  
           HandlerMethod h = (HandlerMethod) handler;  
           //Controller 的包名  
           sb.append("\nController: ").append(h.getBean().getClass().getName()).append("\n");  
           //方法名称  
           sb.append("Method    : ").append(h.getMethod().getName()).append("\n");  
           //请求方式  post\put\get 等等  
           sb.append("RequestMethod    : ").append(request.getMethod()).append("\n");  
           //所有的请求参数  
           sb.append("Params    : ").append(parmeter).append("\n");  
           //部分请求链接  
           sb.append("URI       : ").append(request.getRequestURI()).append("\n");  
            //完整的请求链接  
           sb.append("AllURI    : ").append(reqURL).append("\n");  
           //请求方的 ip地址  
           sb.append("request IP: ").append(ip).append("\n");  
           
           log.info(sb.toString());  
       }
	}

	/**
	 * @Description: 把访问信息传导监控服务器
	 * @param        @param request
	 * @param        @param handler    
	 * @return       void 
	 * @throws IOException 
	 * @throws
	 * @author       z
	 * @datetime     2018年7月3日上午10:45:00
	*/
	private void logOnserver(HttpServletRequest request, Object handler,String userName) throws IOException {
		 // 所有请求第一个进入的方法  
        String reqURL = request.getRequestURL().toString();  
        String ip = IpUtil.getIpAddr(request);
        InputStream  is = request.getInputStream ();  
        StringBuilder responseStrBuilder = new StringBuilder ();  
        BufferedReader streamReader = new BufferedReader (new InputStreamReader (is,"UTF-8"));  
        String inputStr;  
         while ((inputStr = streamReader.readLine ()) != null)  
         responseStrBuilder.append (inputStr);  
         String parmeter = responseStrBuilder.toString();  
           
       VisitLogs vl = new VisitLogs();
       vl.setId(new DefaultKeyGenerator().generateKey().longValue());
       vl.setVititUser(userName);
       vl.setProjectName("第三方管理平台");
       vl.setId(System.currentTimeMillis());
       vl.setVisitDatetime(new Date());
       if (handler instanceof HandlerMethod) {  
           HandlerMethod h = (HandlerMethod) handler;  
           //Controller 的包名  
           vl.setClassName(h.getBean().getClass().getName());
           //方法名称  
           vl.setMethedName(h.getMethod().getName());
           //所有的请求参数  
           vl.setParams(parmeter);
           //部分请求链接  
           vl.setModuleName(request.getRequestURI());//模块加方法
            //完整的请求链接  
           vl.setVisitUrl(reqURL);
           //请求方的 ip地址  
           vl.setVisitIpaddress(ip);
       }
       new ProducerThreadPool().getTaskExecutor().execute(new KafkaProductServer("visitLogs",vl.getId().toString(),vl)); 
	}

}
