package repository.impl;

import models.User;
import org.bson.types.ObjectId;
import org.h2.command.dml.Update;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static configuration.config.datastore;

/**
 * Created by Kuylim on 1/3/2017.
 */

public class UserRopositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() {
        return datastore().createQuery(User.class).asList();
    }

    @Override
    public void save(User user) {
        datastore().save(user);
    }

    @Override
    public boolean update(String id, User user) {
        Query<User> query = datastore().createQuery(User.class).field("_id").equal(new ObjectId(id));
        /*update specific field for comment below*/

        //UpdateOperations<User> ops = datastore().createUpdateOperations(User.class).set("username", user.getUsername());
        datastore().updateFirst(query,user,true);

        //UpdateResults update = datastore().update(query, ups);

        //return update.getUpdatedExisting();
        return true;
    }
}
