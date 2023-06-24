package com.unittestingsprinboot.testingspringbootapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unittestingsprinboot.testingspringbootapp.entities.Book;
import com.unittestingsprinboot.testingspringbootapp.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = BookRestController.class)
public class BookRestControllerTest
{
    @MockBean
    private BookService bookService;
    @Autowired
    private MockMvc mockMvc;

    // success test scenario
    @Test
    public void  addBookTest01() throws Exception {
        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);//any book object use pass it is going to return true
        Book book= new Book(101,"spring",450.00);
        ObjectMapper mapper= new ObjectMapper();// converting object to json format.
         String bookJson=mapper.writeValueAsString(book);
         // above 3 lines for java object to json
        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/addBook")
                .contentType(MediaType.APPLICATION_JSON).content(bookJson);
        // tells the server in which format client is sending the request
        ResultActions perform=mockMvc.perform(requestBuilder);
        MvcResult mvcResult=perform.andReturn();// result  returned;
        MockHttpServletResponse response=mvcResult.getResponse();
        int status=response.getStatus();
        assertEquals(201,status);// compare expected value with actual value.

    }
    // failure test scenario
    @Test
    public void  addBookTest02() throws Exception {
        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);//any book object use pass it is going to return true
        Book book= new Book(101,"spring",450.00);
        ObjectMapper mapper= new ObjectMapper();// converting object to json format.
        String bookJson=mapper.writeValueAsString(book);
        // above 3 lines for java object to json
        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/addBook")
                .contentType(MediaType.APPLICATION_JSON).content(bookJson);
        // tells the server in which format client is sending the request
        ResultActions perform=mockMvc.perform(requestBuilder);
        MvcResult mvcResult=perform.andReturn();// result  returned;
        MockHttpServletResponse response=mvcResult.getResponse();
        int status=response.getStatus();
        assertEquals(400,status);// compare expected value with actual value.

    }
}
