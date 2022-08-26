package kodlamaio.northwind.core.utilities.results.dataAccess;

import kodlamaio.northwind.core.utilities.results.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
