package com.weather.client;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;

import com.github.tomakehurst.wiremock.WireMockServer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherApiClientTest {
	private WireMockServer wireMockServer;
	
	private HashMap <String, String> parameters;
	
	@Autowired
	private OpenWeatherApiClient client;
	

	@Before
	public void configureSystemUnderTest() {
		parameters = new HashMap<>();
		parameters.put("id", "2643743");
		
        this.wireMockServer = new WireMockServer(options().port(8082));
        this.wireMockServer.start();
        
        configureFor("localhost", this.wireMockServer.port());
	}
	
	@After
    public void stopWireMockServer() {
        this.wireMockServer.stop();
    }
	
	@Test
	public void callOpenWeatherTest() throws Exception {
		
		givenThat(get(urlEqualTo("/data/2.5/weather?appid=ddab46b5b0f3fa2271e67061f2df20b8&id=2643743"))
				.willReturn(aResponse()
                .withStatus(200))
        );
		
		ResponseEntity<String> response = client.callOpenWeatherService(parameters);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
