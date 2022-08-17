package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        String json = ctx.body();
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(json, Complaint.class);
        Complaint registeredComplaint = App.complaintService.createComplaint(complaint);
        String complaintJson = gson.toJson(registeredComplaint);

        if(complaintJson != null){
            ctx.status(201);
            ctx.result(complaintJson);
        }else{
            ctx.status(400);
            ctx.result("Could Not Create The Employee!");
        }


    }
}
