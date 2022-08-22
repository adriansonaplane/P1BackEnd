package dev.ledesma.app;

import com.google.gson.Gson;
import dev.ledesma.dao.ComplaintPostgresDAO;
import dev.ledesma.dao.MeetingPostgresDAO;
import dev.ledesma.dao.UserPostgresDAO;

import dev.ledesma.dto.LoginCredential;
import dev.ledesma.entity.User;
import dev.ledesma.handler.*;
import dev.ledesma.service.*;
import io.javalin.Javalin;

public class App {
    public static ComplaintService complaintService = new ComplaintServImp(new ComplaintPostgresDAO());
    public static MeetingService meetingService = new MeetingServImp(new MeetingPostgresDAO());
    public static UserService userService = new UserServImp(new UserPostgresDAO());
    public static LoginService loginService = new LoginServiceImp(new UserPostgresDAO());

    public static void main(String[] args) {

        Javalin app = Javalin.create(config->{
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        CreateUserHandler createUserHandler = new CreateUserHandler();
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();

        ModifyUserHandler modifyUserHandler = new ModifyUserHandler();
        ModifyComplaintHandler modifyComplaintHandler = new ModifyComplaintHandler();

        RetrieveMeetingHandler retrieveMeetingHandler = new RetrieveMeetingHandler();

        //Report Complaints
        app.post("/complaint", createComplaintHandler);
        //View Meetings
        app.get("/meeting", retrieveMeetingHandler);
        //Review Complaints
        app.patch("/complaint/{id}", modifyComplaintHandler);
        //Create Meetings
        app.post("/meeting", createMeetingHandler);
        //Attach Complaints to Meetings
        app.patch("/complaint", modifyComplaintHandler);

        //Request an Accont
        app.post("/user", createUserHandler);
        //Approve Constituent Registration Request
        app.patch("/user", modifyUserHandler);
        //Request to Speak at a specific meeting;

        app.post("/login", ctx -> {
            String body = ctx.body();
            Gson gson = new Gson();
            LoginCredential credentials = gson.fromJson(body, LoginCredential.class);

            User user = loginService.validateUser(credentials.getUsername(), credentials.getPassword());
            String userJson = gson.toJson(user);
            ctx.result(userJson);
        });


        app.start();
    }
}
