package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class ProductDetails implements Serializable {


    private PdtSortOctionBean pdt_SortOction;

    private int Price;
    private int sex;
    private int Comments;
    private int ID;
    private String Name;
    private String begintime;
    private String endtime;
    private int mansum;
    private int manprice;
    private int femalesum;
    private int femaleprice;
    private int marriage;
    private int orderno;
    private int sortid;
    private int isdeleted;
    private String createtime;
    private String introduct;
    private String icon;
    private int groupid;
    private int octionid;
    private int state;
    private int createuserid;
    private String createusername;
    private int totalcollect;
    private int femaleleavesum;
    private int manleavesum;
    private String Number;
    private String LastTime;
    private int NumberCount;
    private int AheadDays;
    private int GradeId;
    private Object TotalComment;
    private Object IsHot;

    private List<CaiXiDetailBean> CaiXiDetail;
    private List<?> PDT_ProductList;
    private List<?> stocks;

    private List<OrderDateListBean> OrderDateList;
    private List<String> Pictures;

    public PdtSortOctionBean getPdt_SortOction() {
        return pdt_SortOction;
    }

    public void setPdt_SortOction(PdtSortOctionBean pdt_SortOction) {
        this.pdt_SortOction = pdt_SortOction;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getComments() {
        return Comments;
    }

    public void setComments(int Comments) {
        this.Comments = Comments;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getMansum() {
        return mansum;
    }

    public void setMansum(int mansum) {
        this.mansum = mansum;
    }

    public int getManprice() {
        return manprice;
    }

    public void setManprice(int manprice) {
        this.manprice = manprice;
    }

    public int getFemalesum() {
        return femalesum;
    }

    public void setFemalesum(int femalesum) {
        this.femalesum = femalesum;
    }

    public int getFemaleprice() {
        return femaleprice;
    }

    public void setFemaleprice(int femaleprice) {
        this.femaleprice = femaleprice;
    }

    public int getMarriage() {
        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getOctionid() {
        return octionid;
    }

    public void setOctionid(int octionid) {
        this.octionid = octionid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(int createuserid) {
        this.createuserid = createuserid;
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    public int getTotalcollect() {
        return totalcollect;
    }

    public void setTotalcollect(int totalcollect) {
        this.totalcollect = totalcollect;
    }

    public int getFemaleleavesum() {
        return femaleleavesum;
    }

    public void setFemaleleavesum(int femaleleavesum) {
        this.femaleleavesum = femaleleavesum;
    }

    public int getManleavesum() {
        return manleavesum;
    }

    public void setManleavesum(int manleavesum) {
        this.manleavesum = manleavesum;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getLastTime() {
        return LastTime;
    }

    public void setLastTime(String LastTime) {
        this.LastTime = LastTime;
    }

    public int getNumberCount() {
        return NumberCount;
    }

    public void setNumberCount(int NumberCount) {
        this.NumberCount = NumberCount;
    }

    public int getAheadDays() {
        return AheadDays;
    }

    public void setAheadDays(int AheadDays) {
        this.AheadDays = AheadDays;
    }

    public int getGradeId() {
        return GradeId;
    }

    public void setGradeId(int GradeId) {
        this.GradeId = GradeId;
    }

    public Object getTotalComment() {
        return TotalComment;
    }

    public void setTotalComment(Object TotalComment) {
        this.TotalComment = TotalComment;
    }

    public Object getIsHot() {
        return IsHot;
    }

    public void setIsHot(Object IsHot) {
        this.IsHot = IsHot;
    }

    public List<CaiXiDetailBean> getCaiXiDetail() {
        return CaiXiDetail;
    }

    public void setCaiXiDetail(List<CaiXiDetailBean> CaiXiDetail) {
        this.CaiXiDetail = CaiXiDetail;
    }

    public List<?> getPDT_ProductList() {
        return PDT_ProductList;
    }

    public void setPDT_ProductList(List<?> PDT_ProductList) {
        this.PDT_ProductList = PDT_ProductList;
    }

    public List<?> getStocks() {
        return stocks;
    }

    public void setStocks(List<?> stocks) {
        this.stocks = stocks;
    }

    public List<OrderDateListBean> getOrderDateList() {
        return OrderDateList;
    }

    public void setOrderDateList(List<OrderDateListBean> OrderDateList) {
        this.OrderDateList = OrderDateList;
    }

    public List<String> getPictures() {
        return Pictures;
    }

    public void setPictures(List<String> Pictures) {
        this.Pictures = Pictures;
    }

    public static class PdtSortOctionBean implements Serializable{
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

    public static class CaiXiDetailBean implements Serializable{


        private PdtProductBean pdt_product;
        private int id;
        private int caixiid;
        private int productid;
        private int category;

        public PdtProductBean getPdt_product() {
            return pdt_product;
        }

        public void setPdt_product(PdtProductBean pdt_product) {
            this.pdt_product = pdt_product;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCaixiid() {
            return caixiid;
        }

        public void setCaixiid(int caixiid) {
            this.caixiid = caixiid;
        }

        public int getProductid() {
            return productid;
        }

        public void setProductid(int productid) {
            this.productid = productid;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public static class PdtProductBean implements Serializable{
            private int MinAdvancePrice;
            private int MinSalePrice;
            private int Id;
            private int SortId;
            private String ProductName;
            private String ProductCode;
            private String Introduce;
            private int CycleDays;
            private int CreateUserId;
            private String CreateUserName;
            private String CreateTime;
            private int Status;
            private String ThumbImg;
            private int IsDeleted;
            private int TotalRead;
            private int TotalCollect;
            private int Hits;
            private String ReleaseTime;
            private int NeedBatchs;
            private String AdvertImg;
            private String BuyMode;
            private String Mobile;
            private int SalePrice;
            private int Category;
            private Object TotalComment;
            private List<?> ProductEntitys;
            private List<?> ProductBatchs;

            public int getMinAdvancePrice() {
                return MinAdvancePrice;
            }

            public void setMinAdvancePrice(int MinAdvancePrice) {
                this.MinAdvancePrice = MinAdvancePrice;
            }

            public int getMinSalePrice() {
                return MinSalePrice;
            }

            public void setMinSalePrice(int MinSalePrice) {
                this.MinSalePrice = MinSalePrice;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getSortId() {
                return SortId;
            }

            public void setSortId(int SortId) {
                this.SortId = SortId;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public String getProductCode() {
                return ProductCode;
            }

            public void setProductCode(String ProductCode) {
                this.ProductCode = ProductCode;
            }

            public String getIntroduce() {
                return Introduce;
            }

            public void setIntroduce(String Introduce) {
                this.Introduce = Introduce;
            }

            public int getCycleDays() {
                return CycleDays;
            }

            public void setCycleDays(int CycleDays) {
                this.CycleDays = CycleDays;
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

            public String getThumbImg() {
                return ThumbImg;
            }

            public void setThumbImg(String ThumbImg) {
                this.ThumbImg = ThumbImg;
            }

            public int getIsDeleted() {
                return IsDeleted;
            }

            public void setIsDeleted(int IsDeleted) {
                this.IsDeleted = IsDeleted;
            }

            public int getTotalRead() {
                return TotalRead;
            }

            public void setTotalRead(int TotalRead) {
                this.TotalRead = TotalRead;
            }

            public int getTotalCollect() {
                return TotalCollect;
            }

            public void setTotalCollect(int TotalCollect) {
                this.TotalCollect = TotalCollect;
            }

            public int getHits() {
                return Hits;
            }

            public void setHits(int Hits) {
                this.Hits = Hits;
            }

            public String getReleaseTime() {
                return ReleaseTime;
            }

            public void setReleaseTime(String ReleaseTime) {
                this.ReleaseTime = ReleaseTime;
            }

            public int getNeedBatchs() {
                return NeedBatchs;
            }

            public void setNeedBatchs(int NeedBatchs) {
                this.NeedBatchs = NeedBatchs;
            }

            public String getAdvertImg() {
                return AdvertImg;
            }

            public void setAdvertImg(String AdvertImg) {
                this.AdvertImg = AdvertImg;
            }

            public String getBuyMode() {
                return BuyMode;
            }

            public void setBuyMode(String BuyMode) {
                this.BuyMode = BuyMode;
            }

            public String getMobile() {
                return Mobile;
            }

            public void setMobile(String Mobile) {
                this.Mobile = Mobile;
            }

            public int getSalePrice() {
                return SalePrice;
            }

            public void setSalePrice(int SalePrice) {
                this.SalePrice = SalePrice;
            }

            public int getCategory() {
                return Category;
            }

            public void setCategory(int Category) {
                this.Category = Category;
            }

            public Object getTotalComment() {
                return TotalComment;
            }

            public void setTotalComment(Object TotalComment) {
                this.TotalComment = TotalComment;
            }

            public List<?> getProductEntitys() {
                return ProductEntitys;
            }

            public void setProductEntitys(List<?> ProductEntitys) {
                this.ProductEntitys = ProductEntitys;
            }

            public List<?> getProductBatchs() {
                return ProductBatchs;
            }

            public void setProductBatchs(List<?> ProductBatchs) {
                this.ProductBatchs = ProductBatchs;
            }
        }
    }

    public static class OrderDateListBean implements Serializable{
        private String Date;
        private int TotalCount;
        private int LeaveCount;
        private List<?> Datalst;

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getLeaveCount() {
            return LeaveCount;
        }

        public void setLeaveCount(int LeaveCount) {
            this.LeaveCount = LeaveCount;
        }

        public List<?> getDatalst() {
            return Datalst;
        }

        public void setDatalst(List<?> Datalst) {
            this.Datalst = Datalst;
        }
    }
}
