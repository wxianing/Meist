package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/25
 */
public class RedEntity implements Serializable {

    private int PageIndex;
    private int RecordCount;

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

    public static class DataListBean {
        private int IsExpires;
        private int Id;
        private String headimgurl;
        private String userName;
        private String memberNumber;
        private String CardNumber;
        private int CardId;
        private int CardDetailId;
        private int UserId;
        private String OrderNo;
        private String CreateTime;
        private int Status;
        private String UsedDateTime;
        private String HeadTitle;
        private int ReliefMoney;
        private int ReliefByOrderMoney;
        private int ReceiveType;
        private int ReceiveByOrderMoney;
        private int ReceiveByUserGrade;
        private int IsUsed;
        private String FromOrderNo;
        private String Note;
        private String CardValidityBeg;
        private String CardValidityEnd;
        private int IsRead;
        private int CardFrom;
        private int OtherPaymentMoney;
        private String OperationUserName;
        private int OperationUserId;

        public int getIsExpires() {
            return IsExpires;
        }

        public void setIsExpires(int IsExpires) {
            this.IsExpires = IsExpires;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getMemberNumber() {
            return memberNumber;
        }

        public void setMemberNumber(String memberNumber) {
            this.memberNumber = memberNumber;
        }

        public String getCardNumber() {
            return CardNumber;
        }

        public void setCardNumber(String CardNumber) {
            this.CardNumber = CardNumber;
        }

        public int getCardId() {
            return CardId;
        }

        public void setCardId(int CardId) {
            this.CardId = CardId;
        }

        public int getCardDetailId() {
            return CardDetailId;
        }

        public void setCardDetailId(int CardDetailId) {
            this.CardDetailId = CardDetailId;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getUsedDateTime() {
            return UsedDateTime;
        }

        public void setUsedDateTime(String UsedDateTime) {
            this.UsedDateTime = UsedDateTime;
        }

        public String getHeadTitle() {
            return HeadTitle;
        }

        public void setHeadTitle(String HeadTitle) {
            this.HeadTitle = HeadTitle;
        }

        public int getReliefMoney() {
            return ReliefMoney;
        }

        public void setReliefMoney(int ReliefMoney) {
            this.ReliefMoney = ReliefMoney;
        }

        public int getReliefByOrderMoney() {
            return ReliefByOrderMoney;
        }

        public void setReliefByOrderMoney(int ReliefByOrderMoney) {
            this.ReliefByOrderMoney = ReliefByOrderMoney;
        }

        public int getReceiveType() {
            return ReceiveType;
        }

        public void setReceiveType(int ReceiveType) {
            this.ReceiveType = ReceiveType;
        }

        public int getReceiveByOrderMoney() {
            return ReceiveByOrderMoney;
        }

        public void setReceiveByOrderMoney(int ReceiveByOrderMoney) {
            this.ReceiveByOrderMoney = ReceiveByOrderMoney;
        }

        public int getReceiveByUserGrade() {
            return ReceiveByUserGrade;
        }

        public void setReceiveByUserGrade(int ReceiveByUserGrade) {
            this.ReceiveByUserGrade = ReceiveByUserGrade;
        }

        public int getIsUsed() {
            return IsUsed;
        }

        public void setIsUsed(int IsUsed) {
            this.IsUsed = IsUsed;
        }

        public String getFromOrderNo() {
            return FromOrderNo;
        }

        public void setFromOrderNo(String FromOrderNo) {
            this.FromOrderNo = FromOrderNo;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public String getCardValidityBeg() {
            return CardValidityBeg;
        }

        public void setCardValidityBeg(String CardValidityBeg) {
            this.CardValidityBeg = CardValidityBeg;
        }

        public String getCardValidityEnd() {
            return CardValidityEnd;
        }

        public void setCardValidityEnd(String CardValidityEnd) {
            this.CardValidityEnd = CardValidityEnd;
        }

        public int getIsRead() {
            return IsRead;
        }

        public void setIsRead(int IsRead) {
            this.IsRead = IsRead;
        }

        public int getCardFrom() {
            return CardFrom;
        }

        public void setCardFrom(int CardFrom) {
            this.CardFrom = CardFrom;
        }

        public int getOtherPaymentMoney() {
            return OtherPaymentMoney;
        }

        public void setOtherPaymentMoney(int OtherPaymentMoney) {
            this.OtherPaymentMoney = OtherPaymentMoney;
        }

        public String getOperationUserName() {
            return OperationUserName;
        }

        public void setOperationUserName(String OperationUserName) {
            this.OperationUserName = OperationUserName;
        }

        public int getOperationUserId() {
            return OperationUserId;
        }

        public void setOperationUserId(int OperationUserId) {
            this.OperationUserId = OperationUserId;
        }
    }
}
