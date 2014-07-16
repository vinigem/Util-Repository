package com.vini.mysite.core.si;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vini.mysite.core.dao.IReplyDao;
import com.vini.mysite.core.ec.Reply;

@Service
public class ReplyServiceImpl implements IReplyService {
	
	@Autowired
	private IReplyDao replyDao;

	@Override
	@Transactional
	public Reply create(Reply reply) {
		return replyDao.create(reply);
	}

	@Override
	public Reply findById(long id) {
		return replyDao.findById(id);
	}

}
