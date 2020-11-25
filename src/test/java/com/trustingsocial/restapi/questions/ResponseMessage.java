package com.trustingsocial.restapi.questions;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseMessage {

    public static Question<Boolean> isEqualTo(String msg){
        return a -> lastResponse().getBody().path("message").equals(msg);
    }
    
   
}