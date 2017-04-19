package com.ldb.test.service;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.utils.JacksonUtil;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.service.BlogAdviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogAdviceServiceTest {

    @Autowired
    private BlogAdviceService blogAdviceService;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Test
    public void testBlogAdviceService(){
        List<BlogAdvicePO> blogAdvicePOList = blogAdviceService.listBlogAdvice(new PageBeanBO(1,20));
        logger.info(JacksonUtil.toJSon(blogAdvicePOList));
    }

}
