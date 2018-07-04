package zhumeng.com.uimei.dao.logs;

import zhumeng.com.uimei.kafka.model.VisitErrorLogs;

public interface VisitErrorLogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VisitErrorLogs record);

    int insertSelective(VisitErrorLogs record);

    VisitErrorLogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VisitErrorLogs record);

    int updateByPrimaryKey(VisitErrorLogs record);
}