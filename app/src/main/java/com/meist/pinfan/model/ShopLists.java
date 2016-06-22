package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package com.meist.pinfan.model
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/22
 */
public class ShopLists implements Serializable {

    /**
     * PageIndex : 1
     * RecordCount : 4
     * DataList : [{"ParentStructureName":null,"StructureId":4,"StructureType":1,"StructureName":"深圳南头店","Address":"南头关内","ParentStructureId":-1,"Remark":"测试店","OrderNo":0,"State":0,"CreateTime":"2016-06-18 14:29:33","CreateUserId":14,"CreateUserName":"admin","AreaName":"广东省-深圳市-南山区","Phone":"13530003888","HeadPhone":null,"LinkMan":"成功","Photo":"http://meist.meidp.com"},{"ParentStructureName":null,"StructureId":3,"StructureType":1,"StructureName":"深圳购物公园","Address":"购物公园一层","ParentStructureId":-1,"Remark":"","OrderNo":0,"State":0,"CreateTime":"2016-03-28 13:09:44","CreateUserId":14,"CreateUserName":"admin","AreaName":"购物公园一层","Phone":"188","HeadPhone":null,"LinkMan":"李李","Photo":"http://meist.meidp.com/upload/201603/25ada79639db4c10b6a1ae69b0c134c2.jpg"},{"ParentStructureName":null,"StructureId":2,"StructureType":1,"StructureName":"深圳分店","Address":"呵呵","ParentStructureId":-1,"Remark":"很好啊，要不要来？","OrderNo":0,"State":1,"CreateTime":"2016-03-23 16:34:52","CreateUserId":14,"CreateUserName":"admin","AreaName":"广东省-深圳市-南山区","Phone":"110","HeadPhone":null,"LinkMan":"呵呵","Photo":"http://meist.meidp.com/upload/201603/42539c7add2e4d33a02e24633419b66a.jpg"},{"ParentStructureName":null,"StructureId":1,"StructureType":1,"StructureName":"平台连锁总部","Address":"中康路卓越城","ParentStructureId":-1,"Remark":"平台连锁总部介绍\n各种好\n好的不得了\n非常好","OrderNo":1,"State":1,"CreateTime":"2015-07-11 00:00:00","CreateUserId":14,"CreateUserName":"admin","AreaName":"广东省-深圳市-福田区","Phone":"18811012138","HeadPhone":null,"LinkMan":"吴经理","Photo":"http://meist.meidp.com/upload/201603/d594e16f97d8405f8dee628644203cc4.jpg"}]
     */

    private int PageIndex;
    private int RecordCount;
    /**
     * ParentStructureName : null
     * StructureId : 4
     * StructureType : 1
     * StructureName : 深圳南头店
     * Address : 南头关内
     * ParentStructureId : -1
     * Remark : 测试店
     * OrderNo : 0
     * State : 0
     * CreateTime : 2016-06-18 14:29:33
     * CreateUserId : 14
     * CreateUserName : admin
     * AreaName : 广东省-深圳市-南山区
     * Phone : 13530003888
     * HeadPhone : null
     * LinkMan : 成功
     * Photo : http://meist.meidp.com
     */

    private List<DataListBean> DataList;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(int RecordCount) {
        this.RecordCount = RecordCount;
    }

    public List<DataListBean> getDataList() {
        return DataList;
    }

    public void setDataList(List<DataListBean> DataList) {
        this.DataList = DataList;
    }

    public static class DataListBean implements Serializable{
        private Object ParentStructureName;
        private int StructureId;
        private int StructureType;
        private String StructureName;
        private String Address;
        private int ParentStructureId;
        private String Remark;
        private int OrderNo;
        private int State;
        private String CreateTime;
        private int CreateUserId;
        private String CreateUserName;
        private String AreaName;
        private String Phone;
        private Object HeadPhone;
        private String LinkMan;
        private String Photo;

        public Object getParentStructureName() {
            return ParentStructureName;
        }

        public void setParentStructureName(Object ParentStructureName) {
            this.ParentStructureName = ParentStructureName;
        }

        public int getStructureId() {
            return StructureId;
        }

        public void setStructureId(int StructureId) {
            this.StructureId = StructureId;
        }

        public int getStructureType() {
            return StructureType;
        }

        public void setStructureType(int StructureType) {
            this.StructureType = StructureType;
        }

        public String getStructureName() {
            return StructureName;
        }

        public void setStructureName(String StructureName) {
            this.StructureName = StructureName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public int getParentStructureId() {
            return ParentStructureId;
        }

        public void setParentStructureId(int ParentStructureId) {
            this.ParentStructureId = ParentStructureId;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public int getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(int OrderNo) {
            this.OrderNo = OrderNo;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(int CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String AreaName) {
            this.AreaName = AreaName;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public Object getHeadPhone() {
            return HeadPhone;
        }

        public void setHeadPhone(Object HeadPhone) {
            this.HeadPhone = HeadPhone;
        }

        public String getLinkMan() {
            return LinkMan;
        }

        public void setLinkMan(String LinkMan) {
            this.LinkMan = LinkMan;
        }

        public String getPhoto() {
            return Photo;
        }

        public void setPhoto(String Photo) {
            this.Photo = Photo;
        }
    }
}
