package com.trainstation.configuration;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TrainStationWebPagesTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).alwaysDo(MockMvcResultHandlers.print())
				.apply(springSecurity()).build();
	}

	@DisplayName("Check GET /stations")
	@WithMockUser(username = "test_user")
	@Test
	public void getStationListTest() throws Exception {
		MvcResult result = mvc.perform(get("/stations?start=0&length=10&startDate=&endDate="))
				.andExpect(status().isOk()).andReturn();
		assertEquals(true, !result.getResponse().getContentAsString().contains("\"data\":[]"));
	}

	@DisplayName("Check GET /trainStationDetail")
	@WithMockUser(username = "test_user")
	@Test
	public void getStationDetailTest() throws Exception {
		mvc.perform(get("/trainStationDetail?stationName=CHEMAINUS"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsStringIgnoringCase("CHEMAINUS")));
	}

}
