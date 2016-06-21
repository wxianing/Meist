package com.hzwl.videoview.model;

import java.io.Serializable;

/**
 * Package：com.hzwl.videoview.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/20
 */
public class Banner implements Serializable {

    /**
     * Id : 15
     * Title : 中秋献礼
     * Photo : http://meist.meidp.com/upload/201603/d43558eed1364fee90c4b8381914ac0b.jpg
     * Link :
     * SortNo : 8
     * CreateUserId : 14
     * CreateUserCnName : admin
     * CreateTime : 2016-03-25 16:08:10
     * UpdateUserId : 14
     * UpdateUserCnName : 管理员
     * UpdateTime : 2016-03-25 16:08:10
     * Status : 1
     * ChannelType : 1
     */

    private int Id;
    private String Title;
    private String Photo;
    private String Link;
    private int SortNo;
    private int CreateUserId;
    private String CreateUserCnName;
    private String CreateTime;
    private int UpdateUserId;
    private String UpdateUserCnName;
    private String UpdateTime;
    private int Status;
    private int ChannelType;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public int getSortNo() {
        return SortNo;
    }

    public void setSortNo(int SortNo) {
        this.SortNo = SortNo;
    }

    public int getCreateUserId() {
        return CreateUserId;
    }

    public void setCreateUserId(int CreateUserId) {
        this.CreateUserId = CreateUserId;
    }

    public String getCreateUserCnName() {
        return CreateUserCnName;
    }

    public void setCreateUserCnName(String CreateUserCnName) {
        this.CreateUserCnName = CreateUserCnName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getUpdateUserId() {
        return UpdateUserId;
    }

    public void setUpdateUserId(int UpdateUserId) {
        this.UpdateUserId = UpdateUserId;
    }

    public String getUpdateUserCnName() {
        return UpdateUserCnName;
    }

    public void setUpdateUserCnName(String UpdateUserCnName) {
        this.UpdateUserCnName = UpdateUserCnName;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getChannelType() {
        return ChannelType;
    }

    public void setChannelType(int ChannelType) {
        this.ChannelType = ChannelType;
    }
}
