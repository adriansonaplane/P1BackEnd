package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateUserHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        String json = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        User registeredUser = App.userService.createUser(user);
        String userJson = gson.toJson(registeredUser);

        if(userJson != null){
            ctx.status(201);
            ctx.result(userJson);
        }else{
            ctx.status(400);
            ctx.result("Could Not Create User");
        }

    }
}
