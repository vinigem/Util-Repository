package com.vini.mysite.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vini.mysite.core.ec.Question;

@Repository
public class QuestionDaoImpl extends GenericDaoImpl<Question> implements IQuestionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAll() {
		return entityManager.createQuery("FROM Question").getResultList();
	}

	

}
