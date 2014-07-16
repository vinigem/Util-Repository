package com.vini.mysite.core.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vini.mysite.core.dao.IQuestionDao;
import com.vini.mysite.core.ec.Question;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	private IQuestionDao questionDao;

	@Override
	@Transactional
	public Question create(Question question) {
		return questionDao.create(question);
	}

	@Override
	public Question findById(long id) {
		return questionDao.findById(id);
	}

	@Override
	public List<Question> findAll() {
		return questionDao.findAll();
	}

}
