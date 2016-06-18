package com.meist.pinfan.model;

import java.io.Serializable;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/16
 */
public class Classify implements Serializable {

    /**
     * Id : 5
     * SortName : 鲁菜
     * ParentId : 0
     * Depth : 1
     * SortOrder : 0
     * Status : 0
     * CreateTime : 2015-12-31 00:00:00
     * Introduce :
     * icon : /upload/201603/bf7a63c5b8874671bcc6c245b9c37f4d.png
     * SimpleIntroduce : 吴总国和测试
     * contacts :
     * Tel :
     * Address :
     * CategoryID : 1
     */

    private int Id;
    private String SortName;
    private int ParentId;
    private int Depth;
    private int SortOrder;
    private int Status;
    private String CreateTime;
    private String Introduce;
    private String icon;
    private String SimpleIntroduce;
    private String contacts;
    private String Tel;
    private String Address;
    private int CategoryID;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSortName() {
        return SortName;
    }

    public void setSortName(String SortName) {
        this.SortName = SortName;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int ParentId) {
        this.ParentId = ParentId;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int Depth) {
        this.Depth = Depth;
    }

    public int getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(int SortOrder) {
        this.SortOrder = SortOrder;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String Introduce) {
        this.Introduce = Introduce;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSimpleIntroduce() {
        return SimpleIntroduce;
    }

    public void setSimpleIntroduce(String SimpleIntroduce) {
        this.SimpleIntroduce = SimpleIntroduce;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }
}
