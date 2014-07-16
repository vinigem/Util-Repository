package com.vini.mysite.core.dao;

import java.util.List;

import com.vini.mysite.core.ec.Question;

public interface IQuestionDao extends GenericDao<Question>{

	List<Question> findAll();

}
