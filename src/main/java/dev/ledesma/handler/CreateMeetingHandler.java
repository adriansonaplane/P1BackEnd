package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateMeetingHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        String json = ctx.body();
        Gson gson = new Gson();
        Meeting meeting = gson.fromJson(json, Meeting.class);
        Meeting registeredMeeting = App.meetingService.createMeeting(meeting);
        String meetingJson = gson.toJson(registeredMeeting);

        if(meetingJson != null){
            ctx.status(201);
            ctx.result(meetingJson);
        }else{
            ctx.status(400);
            ctx.result("Could Not Create Meeting");
        }

    }
}
