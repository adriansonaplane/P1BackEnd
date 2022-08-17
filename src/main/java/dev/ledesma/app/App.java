package dev.ledesma.app;

import dev.ledesma.handler.*;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create();

        CreateUserHandler createUserHandler = new CreateUserHandler();
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();

        ModifyUserHandler modifyUserHandler = new ModifyUserHandler();
        ModifyComplaintHandler modifyComplaintHandler = new ModifyComplaintHandler();

        RetrieveComplaintHandler retrieveComplaintHandler = new RetrieveComplaintHandler();
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



        app.start();
    }
}
