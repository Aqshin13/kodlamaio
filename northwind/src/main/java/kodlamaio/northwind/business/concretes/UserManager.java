package kodlamaio.northwind.business.concretes;


import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.core.utilities.results.dataAccess.UserDao;
import kodlamaio.northwind.core.utilities.results.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("User Added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>("Get User",userDao.findByEmail(email));
    }
}
