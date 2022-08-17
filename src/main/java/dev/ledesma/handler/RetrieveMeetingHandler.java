package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RetrieveMeetingHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        if(App.meetingService.getAllMeetings().size() != 0){
            List<Meeting> meetings = App.meetingService.getAllMeetings();
            Gson gson = new Gson();
            String json = gson.toJson(meetings);
            ctx.status(201);
            ctx.result(json);
        }else{
            ctx.status(404);
            ctx.result("Employee List Is Empty!");
        }


    }
}
