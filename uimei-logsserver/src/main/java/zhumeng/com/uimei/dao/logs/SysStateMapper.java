package zhumeng.com.uimei.dao.logs;

import zhumeng.com.uimei.kafka.model.SysState;

public interface SysStateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysState record);

    int insertSelective(SysState record);

    SysState selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysState record);

    int updateByPrimaryKey(SysState record);
}