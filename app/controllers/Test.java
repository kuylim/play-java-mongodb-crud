package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.User;
import org.bson.types.ObjectId;
import play.libs.Json;
import play.libs.openid.UserInfo;
import play.mvc.Controller;
import play.mvc.Result;
import repository.UserRepository;
import util.Util;

/**
 * Created by Kuylim on 1/3/2017.
 */

public class Test extends Controller {

    @Inject private UserRepository user;
    private User usr;

    public Result save(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.save(Json.fromJson(json, User.class));
        return ok("insert user success");
    }

    public Result query()
    {
        return ok(Json.toJson(user.findAll()));
    }

    public Result update(String id){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.update(id, Json.fromJson(json, User.class));
        return ok(Json.toJson("Update user successfully"));
    }
}
