package com.ldb.pojo.vo;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public class TimeLineVO {

    private String moodArchiveDate;
    List<MoodVO> moodVOList;

    public String getMoodArchiveDate() {
        return moodArchiveDate;
    }

    public void setMoodArchiveDate(String moodArchiveDate) {
        this.moodArchiveDate = moodArchiveDate;
    }

    public List<MoodVO> getMoodVOList() {
        return moodVOList;
    }

    public void setMoodVOList(List<MoodVO> moodVOList) {
        this.moodVOList = moodVOList;
    }
}
