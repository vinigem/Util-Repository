package  com.vini.mysite.core.si;

import  com.vini.mysite.core.ec.User;

public interface IUserService {

	User create(User user);

	User findById(long id);
}
