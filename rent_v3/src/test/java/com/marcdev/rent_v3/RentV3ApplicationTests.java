package com.marcdev.rent_v3;

import com.marcdev.rent_v3.services.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RentV3ApplicationTests {
	@Autowired
	private MockMvc mockMvc;


	@MockBean
	private UserService userService;

	@Test
	public void testUser() throws Exception{
		mockMvc.perform(get("/api/getUser")).andExpect(status().isOk());
	}
	@Test
	void contextLoads() {
	}

}
