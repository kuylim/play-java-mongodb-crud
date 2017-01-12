package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import static configuration.config.datastore;

/**
 * Created by Kuylim on 1/3/2017.
 */
@Entity(value = "users", noClassnameStored = true)
public class User extends Person{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
