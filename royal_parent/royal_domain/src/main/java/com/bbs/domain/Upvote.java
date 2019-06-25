package com.bbs.domain;

/**
 * 点赞模块
 */
public class Upvote {
    private String upvoteUserName;//点赞人
    private Integer upvoteArticleId;//点赞帖子
    private Integer isUpvote;//点赞状态，0代表未点赞，1代表已点赞（默认）
    private String isUpvoteStr;


    public String getUpvoteUserName() {
        return upvoteUserName;
    }

    public void setUpvoteUserName(String upvoteUserName) {
        this.upvoteUserName = upvoteUserName;
    }

    public Integer getUpvoteArticleId() {
        return upvoteArticleId;
    }

    public void setUpvoteArticleId(Integer upvoteArticleId) {
        this.upvoteArticleId = upvoteArticleId;
    }

    public Integer getIsUpvote() {
        return isUpvote;
    }

    public void setIsUpvote(Integer isUpvote) {
        this.isUpvote = isUpvote;
    }

    public String getIsUpvoteStr() {
        //点赞状态，0代表未点赞，1代表已点赞（默认）
        if (isUpvote != null) {
            if (isUpvote == 0) {
                isUpvoteStr = "未点赞";
            } else if (isUpvote == 1) {
                isUpvoteStr = "已点赞";
            }
        }
        return isUpvoteStr;
    }

    public void setIsUpvoteStr(String isUpvoteStr) {
        this.isUpvoteStr = isUpvoteStr;
    }
}
