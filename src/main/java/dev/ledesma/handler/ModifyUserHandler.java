package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class ModifyUserHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        String json = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        User updatedUser = App.userService.updateUser(user);
        String userJson = gson.toJson(updatedUser);

        if(userJson != null){
            ctx.status(201);
            ctx.result(userJson);
        }else{
            ctx.status(404);
            ctx.result("Could not update the user!");
        }


    }
}
