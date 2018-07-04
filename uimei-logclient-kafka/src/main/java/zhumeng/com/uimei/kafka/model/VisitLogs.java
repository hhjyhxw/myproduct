package zhumeng.com.uimei.kafka.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: VisitLogs.java
 * @Package com.zhumeng.uimei.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class VisitLogs implements Serializable{

private static final long serialVersionUID = 3623745595677774651L;
	
	private Long id;
	private String projectName;
	private String moduleName;
	private String className;
	private String methedName;
	private String params;
	private Date visitDatetime;
	private String vititUser;
	private String visitIpaddress;
	private String visitUrl;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethedName() {
		return methedName;
	}
	public void setMethedName(String methedName) {
		this.methedName = methedName;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Date getVisitDatetime() {
		return visitDatetime;
	}
	public void setVisitDatetime(Date visitDatetime) {
		this.visitDatetime = visitDatetime;
	}
	public String getVititUser() {
		return vititUser;
	}
	public void setVititUser(String vititUser) {
		this.vititUser = vititUser;
	}
	public String getVisitIpaddress() {
		return visitIpaddress;
	}
	public void setVisitIpaddress(String visitIpaddress) {
		this.visitIpaddress = visitIpaddress;
	}
	public String getVisitUrl() {
		return visitUrl;
	}
	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}
	
	@Override
	public String toString() {
		return "VisitLogs [id=" + id + ", projectName=" + projectName
				+ ", moduleName=" + moduleName + ", className=" + className
				+ ", methedName=" + methedName + ", params=" + params
				+ ", visitDatetime=" + visitDatetime + ", vititUser="
				+ vititUser + ", visitIpaddress=" + visitIpaddress
				+ ", visitUrl=" + visitUrl + "]";
	}
	
}
