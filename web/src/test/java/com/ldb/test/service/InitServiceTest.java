package com.ldb.test.service;

import com.ldb.service.BlogTagService;
import com.ldb.service.BlogTypeService;
import com.ldb.service.LinkService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ldb on 2017/4/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitServiceTest {

    @Autowired
    private LinkService linkService;
    @Autowired
    private BlogTypeService blogTypeService;
    @Autowired
    private BlogTagService blogTagService;

    @Test
    public void initTest(){
        Assert.assertNotNull(linkService.listLink());
        Assert.assertNotNull(blogTypeService.listBlogType());
        Assert.assertNotNull(blogTagService.listBlogTag());
    }
}
