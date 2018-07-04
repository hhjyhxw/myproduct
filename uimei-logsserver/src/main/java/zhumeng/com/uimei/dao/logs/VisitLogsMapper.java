package zhumeng.com.uimei.dao.logs;

import zhumeng.com.uimei.kafka.model.VisitLogs;

public interface VisitLogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VisitLogs record);

    int insertSelective(VisitLogs record);

    VisitLogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VisitLogs record);

    int updateByPrimaryKey(VisitLogs record);
}