package com.ldb.test.service;

import com.ldb.service.BlogService;
import com.ldb.service.BlogTagService;
import com.ldb.service.BlogTypeService;
import com.ldb.service.LinkService;
import com.ldb.utils.JacksonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ldb on 2017/4/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitServiceTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LinkService linkService;
    @Autowired
    private BlogTypeService blogTypeService;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private BlogService blogService;

    @Test
    public void initTest(){
        Assert.assertNotNull(linkService.listLink());
        Assert.assertNotNull(blogTypeService.listBlogType());
        Assert.assertNotNull(blogTagService.listBlogTag());
        Assert.assertNotNull(blogService.listBlogDateArchive());
        logger.info(JacksonUtil.toJSon(blogService.listBlogDateArchive()));
    }
}
