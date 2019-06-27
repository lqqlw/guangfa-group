package com.bbs.domain;

/**
 * 敏感词汇
 */
public class Word {
    private Integer wordId;
    private String word;//敏感词
    private Integer status;//是否启用 0,启用 1,未启用
    private String statusStr;

    public String getStatusStr() {
        if (status!=null){
            if (status==0){
                statusStr="启用";
            }
            if (status==1){
                statusStr="未启用";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
