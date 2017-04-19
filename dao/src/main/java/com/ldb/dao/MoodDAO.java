package com.ldb.dao;

import com.ldb.pojo.vo.MoodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface MoodDAO {

    List<MoodVO> listMood(@Param("startDate") String startDate, @Param("endDate")String endDate);

    List<String> listMoodArchiveDate();
}
