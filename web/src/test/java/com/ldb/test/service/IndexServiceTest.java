package com.ldb.test.service;

import com.ldb.service.BlogService;
import com.ldb.service.LikeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ldb on 2017/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexServiceTest {

    @Autowired
    private LikeService likeService;

    @Autowired
    private BlogService blogService;

    @Test
    public void testIndex(){
        Assert.assertNotNull(likeService.getLikeCount());
        Assert.assertNotNull(blogService.listNewBlog());
    }


}
