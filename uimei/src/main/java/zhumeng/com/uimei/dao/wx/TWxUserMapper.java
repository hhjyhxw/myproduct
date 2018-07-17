package zhumeng.com.uimei.dao.wx;

import java.util.List;

import zhumeng.com.uimei.model.dbo.wx.TWxUser;

public interface TWxUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TWxUser record);

    int insertSelective(TWxUser record);

    TWxUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TWxUser record);

    int updateByPrimaryKey(TWxUser record);
    
    List<TWxUser> findForList(TWxUser record);
}