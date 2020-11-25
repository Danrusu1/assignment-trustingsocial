package com.trustingsocial.features;

import static com.trustingsocial.restapi.task.UpdateUser.update;
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
@UseTestDataFrom(value="update_user.csv")
public class UpdateSystemStory extends Hook{
	
	private String token;
    private String email;
    private String phoneNumber;
    private int responsesCode;
    private String message;

    public void setToken(String token) {
        this.token = token;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setResponsesCode(int responsesCode) {
        this.responsesCode = responsesCode;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    @Test
    public void UpdatingUserInformation() {
    	
    	JSONObject jsUser = new JSONObject()
    			.element("token", token)
				.element("email", email)
				.element("phone_number", phoneNumber);
    	
    	jacob.attemptsTo(update(jsUser));
    	
    	jacob.should(
    			seeThat("Then application current status is "+responsesCode,
    					ApplicationCurrentStatus.isEqualTo(responsesCode)),
    			
    			seeThat(ResponseMessage.isEqualTo(message)));
    }
}