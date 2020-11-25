package com.trustingsocial.restapi.task;

import static com.trustingsocial.restapi.util.WebServiceEndPoints.USER_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.sf.json.JSONObject;
import net.thucydides.core.annotations.Step;

public class LoginSystem implements Task {

    private JSONObject user;
    
    public LoginSystem(JSONObject user) {
        this.user = user;
    }
    @Override
    @Step("{0} login by user: #user")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Post.to(USER_LOGIN.getUri())
                        .with(request -> request.header("Content-Type", "application/json")
                        .body(user.toString())
                )
        );
    }

    public static LoginSystem login(JSONObject user){
        return instrumented(LoginSystem.class, user);
    }
    
    
}