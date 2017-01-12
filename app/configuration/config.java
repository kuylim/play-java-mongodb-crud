package configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.typesafe.config.ConfigFactory;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import static java.util.Collections.singletonList;
/**
 * Created by Kuylim on 1/3/2017.
 */
public class config {
    public static Datastore datastore;

    public static Datastore datastore(){
        if(datastore == null){
            initDatastore();
        }

        return datastore;
    }

    public static void initDatastore(){
        final Morphia morphia = new Morphia();

        // tell it to fine model class
        morphia.mapPackage("models");

        String host = ConfigFactory.load().getString("mongodb.host");
        int port = ConfigFactory.load().getInt("mongodb.port");
        String username = ConfigFactory.load().getString("mongodb.username");
        String database = ConfigFactory.load().getString("mongodb.database");
        String password = ConfigFactory.load().getString("mongodb.password");


        MongoClient mongoClient = new MongoClient(singletonList(new ServerAddress(host,port)),
                singletonList(MongoCredential.createCredential(username, database, password.toCharArray())));

        datastore = morphia.createDatastore(mongoClient, database);
    }
}
