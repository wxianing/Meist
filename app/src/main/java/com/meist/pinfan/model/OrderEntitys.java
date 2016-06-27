package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/25
 */
public class OrderEntitys implements Serializable {


    /**
     * orderdetails : []
     * Report : null
     * CXNumber : null
     * detaillist : [{"Qty":1,"ProductEntityId":9,"CreateTime":"2016-06-25 15:44:47","Price":30,"OrderId":140,"DisCount":null,"Id":140,"ProductId":9}]
     * ReportDateTime : null
     * RedPacketMoney : null
     * PayTime : null
     * OrderNo : 2016060026
     * IsCommentReply : null
     * PayState : 0
     * UserCardMoney : null
     * TotalMoney : 30
     * UserCardId : null
     * RedPacketId : 0
     * OrderDate : 2016-06-30 00:00:00
     * UserId : 210
     * IsComment : null
     * modifytime : null
     * Status : 1
     * UserSex : null
     * ReportUserId : null
     * Address : null
     * CreateTime : 2016-06-25 15:44:47
     * PayStyle : 0
     * Id : 140
     * Remark : null
     */

    private Object Report;
    private Object CXNumber;
    private Object ReportDateTime;
    private Object RedPacketMoney;
    private Object PayTime;
    private String OrderNo;
    private Object IsCommentReply;
    private int PayState;
    private Object UserCardMoney;
    private int TotalMoney;
    private Object UserCardId;
    private int RedPacketId;
    private String OrderDate;
    private int UserId;
    private Object IsComment;
    private Object modifytime;
    private int Status;
    private Object UserSex;
    private Object ReportUserId;
    private Object Address;
    private String CreateTime;
    private int PayStyle;
    private int Id;
    private Object Remark;
    private List<?> orderdetails;
    /**
     * Qty : 1
     * ProductEntityId : 9
     * CreateTime : 2016-06-25 15:44:47
     * Price : 30
     * OrderId : 140
     * DisCount : null
     * Id : 140
     * ProductId : 9
     */

    private List<DetaillistBean> detaillist;

    public Object getReport() {
        return Report;
    }

    public void setReport(Object Report) {
        this.Report = Report;
    }

    public Object getCXNumber() {
        return CXNumber;
    }

    public void setCXNumber(Object CXNumber) {
        this.CXNumber = CXNumber;
    }

    public Object getReportDateTime() {
        return ReportDateTime;
    }

    public void setReportDateTime(Object ReportDateTime) {
        this.ReportDateTime = ReportDateTime;
    }

    public Object getRedPacketMoney() {
        return RedPacketMoney;
    }

    public void setRedPacketMoney(Object RedPacketMoney) {
        this.RedPacketMoney = RedPacketMoney;
    }

    public Object getPayTime() {
        return PayTime;
    }

    public void setPayTime(Object PayTime) {
        this.PayTime = PayTime;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    public Object getIsCommentReply() {
        return IsCommentReply;
    }

    public void setIsCommentReply(Object IsCommentReply) {
        this.IsCommentReply = IsCommentReply;
    }

    public int getPayState() {
        return PayState;
    }

    public void setPayState(int PayState) {
        this.PayState = PayState;
    }

    public Object getUserCardMoney() {
        return UserCardMoney;
    }

    public void setUserCardMoney(Object UserCardMoney) {
        this.UserCardMoney = UserCardMoney;
    }

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public Object getUserCardId() {
        return UserCardId;
    }

    public void setUserCardId(Object UserCardId) {
        this.UserCardId = UserCardId;
    }

    public int getRedPacketId() {
        return RedPacketId;
    }

    public void setRedPacketId(int RedPacketId) {
        this.RedPacketId = RedPacketId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public Object getIsComment() {
        return IsComment;
    }

    public void setIsComment(Object IsComment) {
        this.IsComment = IsComment;
    }

    public Object getModifytime() {
        return modifytime;
    }

    public void setModifytime(Object modifytime) {
        this.modifytime = modifytime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Object getUserSex() {
        return UserSex;
    }

    public void setUserSex(Object UserSex) {
        this.UserSex = UserSex;
    }

    public Object getReportUserId() {
        return ReportUserId;
    }

    public void setReportUserId(Object ReportUserId) {
        this.ReportUserId = ReportUserId;
    }

    public Object getAddress() {
        return Address;
    }

    public void setAddress(Object Address) {
        this.Address = Address;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getPayStyle() {
        return PayStyle;
    }

    public void setPayStyle(int PayStyle) {
        this.PayStyle = PayStyle;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public List<?> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<?> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public List<DetaillistBean> getDetaillist() {
        return detaillist;
    }

    public void setDetaillist(List<DetaillistBean> detaillist) {
        this.detaillist = detaillist;
    }

    public static class DetaillistBean {
        private int Qty;
        private int ProductEntityId;
        private String CreateTime;
        private int Price;
        private int OrderId;
        private Object DisCount;
        private int Id;
        private int ProductId;

        public int getQty() {
            return Qty;
        }

        public void setQty(int Qty) {
            this.Qty = Qty;
        }

        public int getProductEntityId() {
            return ProductEntityId;
        }

        public void setProductEntityId(int ProductEntityId) {
            this.ProductEntityId = ProductEntityId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getOrderId() {
            return OrderId;
        }

        public void setOrderId(int OrderId) {
            this.OrderId = OrderId;
        }

        public Object getDisCount() {
            return DisCount;
        }

        public void setDisCount(Object DisCount) {
            this.DisCount = DisCount;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getProductId() {
            return ProductId;
        }

        public void setProductId(int ProductId) {
            this.ProductId = ProductId;
        }
    }
}
