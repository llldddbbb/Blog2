package com.ldb.pojo.po;

import com.ldb.pojo.vo.CommentReplyVO;

import java.util.Date;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public class CommentPO {
    private Integer id;

    private String nickName;

    private String userIP;

    private String content;

    private Date publishTime;

    private Integer blogId;

    private List<CommentReplyVO> commentReplyVOList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP == null ? null : userIP.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public List<CommentReplyVO> getCommentReplyVOList() {
        return commentReplyVOList;
    }

    public void setCommentReplyVOList(List<CommentReplyVO> commentReplyVOList) {
        this.commentReplyVOList = commentReplyVOList;
    }
}
