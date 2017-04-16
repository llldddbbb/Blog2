package com.ldb.pojo.vo;

import java.util.Date;

/**
 * Created by ldb on 2017/4/16.
 */
public class BlogDateArchiveVO {

    private Date archiveDate;
    private Integer totalNum;

    public Date getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}
