package com.hzwl.videoview.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.hzwl.videoview.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/20
 */
public class Video implements Serializable {

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
        private int Id;
        private String VideoName;
        private String FilePath;
        private String CreateTime;
        private int CreateUserId;
        private String Remark;
        private int Status;
        private int FileSize;
        private int SortNo;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getVideoName() {
            return VideoName;
        }

        public void setVideoName(String VideoName) {
            this.VideoName = VideoName;
        }

        public String getFilePath() {
            return FilePath;
        }

        public void setFilePath(String FilePath) {
            this.FilePath = FilePath;
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

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getFileSize() {
            return FileSize;
        }

        public void setFileSize(int FileSize) {
            this.FileSize = FileSize;
        }

        public int getSortNo() {
            return SortNo;
        }

        public void setSortNo(int SortNo) {
            this.SortNo = SortNo;
        }
    }
}
