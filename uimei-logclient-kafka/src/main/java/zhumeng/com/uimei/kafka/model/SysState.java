package zhumeng.com.uimei.kafka.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: SysState.java
 * @Package com.zhumeng.uimei
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class SysState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -588115001871723621L;
	
	private Long id;
	private String hostIpaddress; //服务器地址
	private String cupRate;//cup使用率
	private String totalMemory;//服务器内存大小
	private String usedMemory;//服务器已用内存
	private String freeMemory;//服务器空闲内存
	private String jvmMaxMemory;//jvm实例可以从操作系统获取的最大内存
	private String jvmTotalMemory;//jvm实际从操作系统获取的内存
	private String jvmFreeMemory;//jvm空闲内存
	private String jvmUsedMrmory;//jvm已用内存
	private Date createDatetime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHostIpaddress() {
		return hostIpaddress;
	}
	public void setHostIpaddress(String hostIpaddress) {
		this.hostIpaddress = hostIpaddress;
	}
	public String getCupRate() {
		return cupRate;
	}
	public void setCupRate(String cupRate) {
		this.cupRate = cupRate;
	}
	public String getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(String totalMemory) {
		this.totalMemory = totalMemory;
	}
	public String getUsedMemory() {
		return usedMemory;
	}
	public void setUsedMemory(String usedMemory) {
		this.usedMemory = usedMemory;
	}
	public String getFreeMemory() {
		return freeMemory;
	}
	public void setFreeMemory(String freeMemory) {
		this.freeMemory = freeMemory;
	}
	public String getJvmMaxMemory() {
		return jvmMaxMemory;
	}
	public void setJvmMaxMemory(String jvmMaxMemory) {
		this.jvmMaxMemory = jvmMaxMemory;
	}
	public String getJvmTotalMemory() {
		return jvmTotalMemory;
	}
	public void setJvmTotalMemory(String jvmTotalMemory) {
		this.jvmTotalMemory = jvmTotalMemory;
	}
	public String getJvmFreeMemory() {
		return jvmFreeMemory;
	}
	public void setJvmFreeMemory(String jvmFreeMemory) {
		this.jvmFreeMemory = jvmFreeMemory;
	}
	public String getJvmUsedMrmory() {
		return jvmUsedMrmory;
	}
	public void setJvmUsedMrmory(String jvmUsedMrmory) {
		this.jvmUsedMrmory = jvmUsedMrmory;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	
	@Override
	public String toString() {
		return "SysState [id=" + id + ", hostIpaddress=" + hostIpaddress
				+ ", cupRate=" + cupRate + ", totalMemory=" + totalMemory
				+ ", usedMemory=" + usedMemory + ", freeMemory=" + freeMemory
				+ ", jvmMaxMemory=" + jvmMaxMemory + ", jvmTotalMemory="
				+ jvmTotalMemory + ", jvmFreeMemory=" + jvmFreeMemory
				+ ", jvmUsedMrmory=" + jvmUsedMrmory + ", createDatetime="
				+ createDatetime + "]";
	}
	
	
}
