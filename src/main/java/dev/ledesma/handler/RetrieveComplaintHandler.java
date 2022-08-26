package dev.ledesma.handler;

import com.google.gson.Gson;
import dev.ledesma.app.App;
import dev.ledesma.entity.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RetrieveComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        if(App.complaintService.getAllComplaints().size() != 0){
            List<Complaint> complaints = App.complaintService.getAllComplaints();
            Gson gson = new Gson();
            String json = gson.toJson(complaints);
            ctx.status(201);
            ctx.result(json);
        }else{
            ctx.status(404);
            ctx.result("Employee List Is Empty!");
        }


    }
}
