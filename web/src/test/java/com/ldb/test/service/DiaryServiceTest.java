package com.ldb.test.service;

import com.ldb.service.TimeLineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ldb on 2017/4/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DiaryServiceTest {

    @Autowired
    private TimeLineService timeLineService;

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void testMoodService(){
        timeLineService.listTimeLine();
    }
}
