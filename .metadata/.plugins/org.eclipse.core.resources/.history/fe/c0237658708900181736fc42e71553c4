package zhumeng.com.uimei.service.wx.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhumeng.com.uimei.dao.wx.TWxReplyMapper;
import zhumeng.com.uimei.model.dbo.wx.TWxReply;
import zhumeng.com.uimei.service.wx.TWxReplyService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Title: TWxReplyServiceImpl.java
 * @Package zhumeng.com.uimei.service.wx.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月16日
 * @version V1.0
 */
@Service
@Transactional
public class TWxReplyServiceImpl implements  TWxReplyService{

	@Autowired
	private TWxReplyMapper wxReplyMapper;
	@Override
	public void save(TWxReply record) throws Exception {
		wxReplyMapper.insert(record);
	}

	
	@Override
	public void update(TWxReply record) throws Exception {
		wxReplyMapper.updateByPrimaryKeySelective(record);
	}

	
	@Override
	public List<TWxReply> findList(TWxReply record) throws Exception {
		// TODO Auto-generated method stub
		return wxReplyMapper.findForList(record);
	}


	@Override
	public Integer findCount(TWxReply record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void delete(Long id) throws Exception {
		wxReplyMapper.deleteByPrimaryKey(id);
	}


	@Override
	public TWxReply findByKey(Long id) {
		return wxReplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TWxReply> findByPage(int pageNo, int pageSize,
			TWxReply record) throws Exception {
		PageHelper.startPage(pageNo, pageSize);
		return new PageInfo<TWxReply>(wxReplyMapper.findForList(record));
	}
}
