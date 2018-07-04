package zhumeng.com.uimei.service.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.com.uimei.dao.logs.SysStateMapper;
import zhumeng.com.uimei.kafka.model.SysState;
import zhumeng.com.uimei.service.SERVICE;

/**
 * @Title: SysStateService.java
 * @Package zhumeng.com.uimei.service.logs
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月4日
 * @version V1.0
 */
@Service
public class SysStateService implements SERVICE<SysState>{

	@Autowired
	private SysStateMapper sysStateMapper;

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return sysStateMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insert(java.lang.Object)
	 */
	@Override
	public int insert(SysState record) {
		// TODO Auto-generated method stub
		return sysStateMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(SysState record) {
		// TODO Auto-generated method stub
		return sysStateMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public SysState selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return sysStateMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(SysState record) {
		// TODO Auto-generated method stub
		return sysStateMapper.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(SysState record) {
		// TODO Auto-generated method stub
		return sysStateMapper.updateByPrimaryKey(record);
	}
	
}
