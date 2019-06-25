package com.bbs.domain;

/**
 * 交流区模块
 */
public class Zone {
    private Integer zoneId;//交流区编号
    private String zoneName;//交流区名字
    private Integer isDef;//是否默认，1代表默认，2代表非默认
    private String isDefStr;

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public String getIsDefStr() {
        //是否默认，1代表默认，2代表非默认
        if (isDef != null) {
            if (isDef == 1) {
                isDefStr = "默认";
            } else if (isDef == 2) {
                isDefStr = "非默认";
            }
        }
        return isDefStr;
    }

    public void setIsDefStr(String isDefStr) {
        this.isDefStr = isDefStr;
    }
}
