package com.java.boot.demo.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.java.boot.demo.hello.HelloController;



@RunWith(SpringRunner.class)
 @WebMvcTest(HelloController.class)
/*@AutoConfigureMockMvc*/

public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
   public void displayMessage() throws Exception{
	   
	  mockMvc.perform(get("/api/hello")).andExpect(status().isOk())
	   .andExpect(content().string("hello"));
	   
   }
    
    
    @Test
    
    public void getAllCustomer() throws Exception {
        mockMvc.perform(get("/api/customers")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userName").value("anubhav")).andExpect(jsonPath("$[0].password").value("arpit0905"))
                .andExpect(jsonPath("$[1].userName").value("Yash")).andExpect(jsonPath("$[1].password").value("arpit0906"));
                
    }
    
    public void getSingleCustomer() throws Exception {
        mockMvc.perform(get("/api/customers/{customerId}",1)).andExpect(status().isOk())
        .andExpect(jsonPath("$.userName").value("Yash")).andExpect(jsonPath("$.password").value("arpit0906"));
                
}}