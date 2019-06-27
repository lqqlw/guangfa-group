package com.bbs.domain;

import java.util.Date;

/**
 * 帖子信息
 */
public class Article {
    private Integer articleId;//帖子编号
    private String title;//标题
    private String content;//内容
    private Date sendTime;//发送时间
    private String senderName;//发送人编号
    private Integer isTop;//是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private String isTopStr;
    private Integer replyCount;//评论数
    private Integer upvoteCount;//点赞数
    private Integer browseCount;//浏览数
    private Integer zoneId;//所在交流区
    private String zonIdStr;
    private Integer isReport;//举报状态

    public String getZonIdStr() {
        if (zoneId!=null){
            if (zoneId==1){
                zonIdStr="综合交流区";
            }
            if(zoneId==2){
                zonIdStr="bug反馈区";
            }
            if (zoneId==3){
                zonIdStr="新闻公告区";
            }
            if (zoneId==4){
                zonIdStr="活动专区";
            }
        }
        return zonIdStr;
    }

    public void setZonIdStr(String zonIdStr) {
        this.zonIdStr = zonIdStr;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getIsTopStr() {

        if(isTop!=null){
            if (isTop==0){
                isTopStr="否";
            }
            if(isTop==1){
                isTopStr="是";
            }
        }
        return isTopStr;
    }

    public void setIsTopStr(String isTopStr) {
        this.isTopStr = isTopStr;
    }
}
