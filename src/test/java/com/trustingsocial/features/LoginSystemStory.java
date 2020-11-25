package com.trustingsocial.features;

import static com.trustingsocial.restapi.task.LoginSystem.login;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.trustingsocial.Hook;
import com.trustingsocial.restapi.questions.ApplicationCurrentStatus;
import com.trustingsocial.restapi.questions.ResponseMessage;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.sf.json.JSONObject;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="users.csv")
public class LoginSystemStory extends Hook{
	
	private String userName;
    private String password;
    private int responsesCode;
    private String message;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setResponsesCode(int responsesCode) {
        this.responsesCode = responsesCode;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }



    @Test
    public void LoginSystem() {
    	
    	JSONObject jsUser = new JSONObject()
				.element("user_name", userName)
				.element("password", password);
    	
    	jacob.attemptsTo(login(jsUser));
    	
    	jacob.should(
    			seeThat("Then application current status is "+responsesCode,
    					ApplicationCurrentStatus.isEqualTo(responsesCode)),
    			
    			seeThat(ResponseMessage.isEqualTo(message)));
    }
}