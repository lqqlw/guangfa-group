package com.bbs.domain;

import java.util.Date;

/**
 * 举报模块
 */
public class Report {
    private Integer reportId;//举报id
    private String reportContent;//举报内容
    private Date reportTime;//举报时间
    private String reportUserName;//举报人
    private Integer reportStatus;//处理状态
    private String reportStatusStr;
    private Integer articleId;//文章ID

    public String getReportStatusStr() {
        if (reportStatus!=null){
            if (reportStatus ==1){
                reportStatusStr="已驳回";
            }
            if (reportStatus==0){
                reportStatusStr="已屏蔽";
            }
        }

        return reportStatusStr;
    }

    public void setReportStatusStr(String reportStatusStr) {
        this.reportStatusStr = reportStatusStr;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
