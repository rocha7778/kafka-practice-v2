package com.rocha.app.a.product.course;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocha.app.a.product.entity.Product;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.ANY)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void getAllProducts() throws Exception {
		this.mockMvc.perform(get("/products")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Ritchie")));

	}

	@Test
	void getProduct_notFound() throws Exception {
		this.mockMvc.perform(get("/products/1001")).andExpect(status().isNotFound());
	}
	
	@Test
	void createProduct() throws Exception{
	
	
		Product p = Product.builder()
		.id(1001L)		
		.createdAt(new Date())
		.updatedAt(LocalDateTime.now())
		.name("Nike")
		.description("Just do it")
		.price(10.5)
		.quantity(10.0)
		.build();
		
		
		ObjectMapper mapper = new ObjectMapper();
	    String jsonString = mapper.writeValueAsString(p);
	    
		this.mockMvc.perform(post("/products")
				.content(jsonString)
				.contentType("application/json"))
		.andExpect(status().isCreated());
		
	}

}
