package com.ldb.service;

import com.ldb.pojo.po.MoodPO;
import com.ldb.pojo.vo.TimeLineVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface TimeLineService {

    List<TimeLineVO> listTimeLine();

    List<MoodPO> listMoodPO(HashMap<String,Object> param);

    Long getMoodCount();

    int updateMood(MoodPO moodPO);

    int addMood(MoodPO moodPO);
}
