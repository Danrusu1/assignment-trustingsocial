package com.trustingsocial;

import org.junit.Before;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    protected Actor jacob = Actor.named("Jacob");
    private String theRestApiBaseUrl;
    
	private EnvironmentVariables environmentVariables;

    @Before
    public void jacobCanCallTheApi() {

		theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.root")
				.orElse("https://reqres.in/api");
		
		OnStage.setTheStage(new OnlineCast());
    	jacob.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
