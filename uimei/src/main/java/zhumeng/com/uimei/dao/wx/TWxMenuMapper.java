package zhumeng.com.uimei.dao.wx;

import java.util.List;

import zhumeng.com.uimei.model.dbo.wx.TWxMenu;

public interface TWxMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TWxMenu record);

    int insertSelective(TWxMenu record);

    TWxMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TWxMenu record);

    int updateByPrimaryKey(TWxMenu record);
    
    
    List<TWxMenu> findForList(TWxMenu record);
}