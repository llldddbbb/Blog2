package com.ldb.dao;

import com.ldb.pojo.po.MoodPO;
import com.ldb.pojo.vo.MoodVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface MoodDAO {

    List<MoodVO> listMoodVO(HashMap<String ,String> param);

    List<String> listMoodArchiveDate();

    List<MoodPO> listMoodPO(HashMap<String ,Object> param);

    Long getMoodCount();

    int updateMood(MoodPO moodPO);

    int addMood(MoodPO moodPO);
}
