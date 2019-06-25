package com.bbs.domain;

import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * 评论模块
 */
public class Comment {
    private Integer commentId;//评论编号
    private String commentContent;//评论内容
    private Date commentTime;//评论时间
    private String commentUserName;//评论人
    private Integer commentStatus;//评论状态 1，屏蔽 0，解除
    private String commentStatusStr;
    private Integer articleId;//帖子编号

    public String getCommentStatusStr() {
        if (commentStatus !=null){
            if (commentStatus ==1){
                commentStatusStr="屏蔽";
            }
            if (commentStatus ==0){
                commentStatusStr="解除";
            }
        }
        return commentStatusStr;
    }

    public void setCommentStatusStr(String commentStatusStr) {
        this.commentStatusStr = commentStatusStr;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
