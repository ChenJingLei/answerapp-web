package app.repositories;

import app.models.User;
import org.springframework.data.repository.*;

/**
 * Created by cjl20 on 2015/10/19.
 */

public interface UserRepository extends CrudRepository<User,Long>{



}
