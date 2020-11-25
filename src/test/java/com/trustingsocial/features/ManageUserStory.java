package com.trustingsocial.features;

import static com.trustingsocial.restapi.builders.UserBuilder.named;
import static com.trustingsocial.restapi.task.CreateUser.createUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.trustingsocial.Hook;
import com.trustingsocial.restapi.questions.ApplicationCurrentStatus;
import com.trustingsocial.restapi.questions.ResponseMessage;
import com.trustingsocial.restapi.status.AppStatus;

import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class ManageUserStory extends Hook{

    @Test
    public void WhenCreatingAnUserSuccess() {
    	
    	jacob.attemptsTo(
    			createUser(named("vuthelinh")
        			.withPassword("tr4stM3Pls")
        			.withEmail("vuthelinh@sdet.com")
        			.withPhoneNumber("+84987000000"))
        );
    	
    	jacob.should(
    			seeThat("Then application current status is "+AppStatus.RUNNING,
    					ApplicationCurrentStatus.isEqualTo(AppStatus.RUNNING.getCode())),
    			
    			seeThat(ResponseMessage.isEqualTo("user is created")));
    }
    
    @Test
    public void WhenCreatingAnUserWithInvalideEmail() {
    	
    	jacob.attemptsTo(
    			createUser(named("vuthelinh")
        			.withPassword("tr4stM3Pls")
        			.withEmail("vuthelinh.mail.com")
        			.withPhoneNumber("+84987000000"))
        );
    	
    	jacob.should(
    			seeThat("Then application current status is "+AppStatus.BAD_REQUEST,
    					ApplicationCurrentStatus.isEqualTo(AppStatus.BAD_REQUEST.getCode())),
    			
    			seeThat(ResponseMessage.isEqualTo("invalid parameter")));
    }
    
}
