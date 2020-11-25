package com.trustingsocial.restapi.task;

import static com.trustingsocial.restapi.util.WebServiceEndPoints.USER_UPDATE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.sf.json.JSONObject;
import net.thucydides.core.annotations.Step;

public class UpdateUser implements Task {

    private String user;
    
    public UpdateUser(JSONObject user) {
        this.user = user.toString();
    }
    @Override
    @Step("{0} update information: #user")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Post.to(USER_UPDATE.getUri())
                        .with(request -> request.header("Content-Type", "application/json")
                        .body(user)
                )
        );
    }

    public static UpdateUser update(JSONObject user){
        return instrumented(UpdateUser.class, user);
    }
    
    
}