package com.unittestingsprinboot.testingspringbootapp.controller;

import com.unittestingsprinboot.testingspringbootapp.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;
@WebMvcTest(value = WelcomeRestController.class) // used to represent it is used to test which target class
public class WelcomeRestControllerTest {
    @MockBean // to create mock object for dependent
    private WelcomeService welcomeService;

    @Autowired
    private MockMvc mockMvc;  // inorder to send request to rest controller we use this component(MockMvc)
    @Test
     public  void welcomeMsgTest() throws Exception {
         when(welcomeService.getWelcomeMessage()).thenReturn(" hello world");// here mocking performed
         //call rest controller method  here we are not going to create object for rest controller method
         // here we need to sent get request to rest controller method
         // if normal java class create object call the methods
         // here we need to invoke rest controller method by sending http request.
         // Note :we need to send request to rest controller method using http
          MockHttpServletRequestBuilder  requestBuilder= MockMvcRequestBuilders.get("/welcome");// construct get request for /welcome url pattern
          ResultActions perform=mockMvc.perform(requestBuilder);
          MvcResult mvcResult=perform.andReturn();// result  returned;
          MockHttpServletResponse response=mvcResult.getResponse();
          int status=response.getStatus();
          assertEquals(200,status);// compare expected value with actual value.

     }

}
