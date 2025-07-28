package com.rajeev.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	private MockMvc mockMvc;

	//@Test
	public void testGreetMessage() throws Exception{
		String name="Rajeev";
		mockMvc.perform(MockMvcRequestBuilders.get("/greeting/{name}", name))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello "+name));

	}
}
