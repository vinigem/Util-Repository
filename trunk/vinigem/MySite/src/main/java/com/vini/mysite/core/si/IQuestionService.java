package  com.vini.mysite.core.si;

import java.util.List;

import com.vini.mysite.core.ec.Question;


public interface IQuestionService {
	
	Question create(Question question);

	Question findById(long id);
	
	List<Question> findAll();

}
