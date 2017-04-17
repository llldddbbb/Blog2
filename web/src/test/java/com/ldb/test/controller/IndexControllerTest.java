package com.ldb.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by ldb on 2017/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddLike() throws Exception{
       /* RequestBuilder request = null;
        request = post("/like");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo(ConfigStrUtil.SUCCESS)));*/
    }

}
