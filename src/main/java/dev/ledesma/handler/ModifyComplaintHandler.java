package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class ModifyComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        String json = ctx.body();
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(json, Complaint.class);
        Complaint updatedComplaint = App.complaintService.updateComplaint(complaint);
        String complaintJson = gson.toJson(updatedComplaint);

        if(complaintJson !=  null){
            ctx.status(201);
            ctx.result(complaintJson);
        }else{
            ctx.status(404);
            ctx.result("Could not update complaint!");
        }




    }
}
