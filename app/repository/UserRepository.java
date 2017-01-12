package repository;

import com.google.inject.ImplementedBy;
import models.User;
import repository.impl.UserRopositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuylim on 1/3/2017.
 */
@ImplementedBy(UserRopositoryImpl.class)
public interface UserRepository {

    void save(User user);

    List<User> findAll();

    boolean update(String id ,User user);

}
