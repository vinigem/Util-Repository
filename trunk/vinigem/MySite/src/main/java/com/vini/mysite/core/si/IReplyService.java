package  com.vini.mysite.core.si;

import  com.vini.mysite.core.ec.Reply;


public interface IReplyService {
	
	Reply create(Reply reply);

	Reply findById(long id);

}
