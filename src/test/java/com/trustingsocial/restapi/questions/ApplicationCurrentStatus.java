package com.trustingsocial.restapi.questions;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ApplicationCurrentStatus {

    public static Question<Boolean> isEqualTo(int code){
        return a -> lastResponse().statusCode() == code;
    }
    
   
}