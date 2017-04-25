package com.ldb.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by ldb on 2017/4/16.
 */
public class BlogPO {
    private Integer id;

    private String title;

    private String author;

    private String summary;

    private String coverImageName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;

    private Integer readNum;

    private Boolean is_Recommend;

    private Integer blogTypeId;

    private Integer blogTagId;

    private String content;

    private BlogTypePO blogTypePO;

    private BlogTagPO blogTagPO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImageName() {
        return coverImageName;
    }

    public void setCoverImageName(String coverImageName) {
        this.coverImageName = coverImageName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Boolean getIs_Recommend() {
        return is_Recommend;
    }

    public void setIs_Recommend(Boolean is_Recommend) {
        this.is_Recommend = is_Recommend;
    }

    public Integer getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(Integer blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    public Integer getBlogTagId() {
        return blogTagId;
    }

    public void setBlogTagId(Integer blogTagId) {
        this.blogTagId = blogTagId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogTypePO getBlogTypePO() {
        return blogTypePO;
    }

    public void setBlogTypePO(BlogTypePO blogTypePO) {
        this.blogTypePO = blogTypePO;
    }

    public BlogTagPO getBlogTagPO() {
        return blogTagPO;
    }

    public void setBlogTagPO(BlogTagPO blogTagPO) {
        this.blogTagPO = blogTagPO;
    }


}
