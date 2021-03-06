package zhumeng.com.uimei.service.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.com.uimei.dao.logs.VisitLogsMapper;
import zhumeng.com.uimei.kafka.model.VisitLogs;
import zhumeng.com.uimei.service.SERVICE;

/**
 * @Title: VisitLogsService.java
 * @Package zhumeng.com.uimei.service.logs
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月4日
 * @version V1.0
 */
@Service
public class VisitLogsService implements SERVICE<VisitLogs>{

	@Autowired
	private VisitLogsMapper visitLogsMapper;
	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return visitLogsMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insert(java.lang.Object)
	 */
	@Override
	public int insert(VisitLogs t) {
		// TODO Auto-generated method stub
		return visitLogsMapper.insert(t);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(VisitLogs t) {
		// TODO Auto-generated method stub
		return visitLogsMapper.insert(t);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public VisitLogs selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return visitLogsMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(VisitLogs t) {
		// TODO Auto-generated method stub
		return visitLogsMapper.updateByPrimaryKeySelective(t);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(VisitLogs record) {
		// TODO Auto-generated method stub
		return visitLogsMapper.updateByPrimaryKey(record);
	}

}
