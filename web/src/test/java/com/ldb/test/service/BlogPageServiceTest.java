package com.ldb.test.service;

import com.ldb.controller.utils.JacksonUtil;
import com.ldb.pojo.po.CommentPO;
import com.ldb.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ldb on 2017/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogPageServiceTest {

    @Autowired
    private CommentService commentService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Test
    public void testCommentService(){
        List<CommentPO> commentPOList = commentService.listComment(2);
        // int result=commentService.addComment(new CommentPO("小罗","127.0.0.1","滴",2));
        // Assert.assertEquals(result,1);
        logger.info(JacksonUtil.toJSon(commentPOList));
    }

}
