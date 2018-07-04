package zhumeng.com.uimei.service.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.com.uimei.dao.logs.VisitErrorLogsMapper;
import zhumeng.com.uimei.kafka.model.VisitErrorLogs;
import zhumeng.com.uimei.service.SERVICE;

/**
 * @Title: VisitErrorLogsService.java
 * @Package zhumeng.com.uimei.service.logs
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月4日
 * @version V1.0
 */
@Service
public class VisitErrorLogsService implements SERVICE<VisitErrorLogs>{

	@Autowired
	private VisitErrorLogsMapper visitErrorLogsMapper;

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insert(java.lang.Object)
	 */
	@Override
	public int insert(VisitErrorLogs record) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(VisitErrorLogs record) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public VisitErrorLogs selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(VisitErrorLogs record) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see zhumeng.com.uimei.service.SERVICE#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(VisitErrorLogs record) {
		// TODO Auto-generated method stub
		return visitErrorLogsMapper.updateByPrimaryKey(record);
	}
	
}
