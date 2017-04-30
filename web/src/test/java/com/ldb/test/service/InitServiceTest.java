package com.ldb.test.service;

import com.ldb.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

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
    @Autowired
    private MottoService mottoService;
    @Autowired
    private SignatureService signatureService;

    @Test
    public void testInit(){
        Assert.assertNotNull(linkService.listLink(new HashMap<>()));
        Assert.assertNotNull(blogTypeService.listBlogType());
        Assert.assertNotNull(blogTagService.listBlogTag(new HashMap<>()));
        Assert.assertNotNull(blogService.listBlogDateArchive());
        Assert.assertNotNull(mottoService.getMotto());
        Assert.assertNotNull(signatureService.getSignature());
        Assert.assertNotNull(blogService.getRecommendBlog());
    }
}
