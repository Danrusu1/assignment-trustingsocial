package com.trustingsocial.restapi.task;

import static com.trustingsocial.restapi.util.WebServiceEndPoints.CREATE_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.trustingsocial.models.User;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class CreateUser implements Task {

    private User user;
    
    public CreateUser(User user) {
        this.user = user;
    }
    @Override
    @Step("{0} create an user: #user")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Post.to(CREATE_USER.getUri())
                        .with(request -> request.header("Content-Type", "application/json")
                        .body(user)
                )
        );
    }

    public static CreateUser createUser(User user){
        return instrumented(CreateUser.class, user);
    }
    
    
}