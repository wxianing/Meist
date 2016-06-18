package com.hzwl.videoview.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package com.meist.pinfan.model
 * 作 用：
 * 创建人：wxianing
 * 时 间：2016/6/12
 */
public class AppBean implements Serializable {
    private int code;
    private int enumcode;
    private String msg;

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getEnumcode() {
        return enumcode;
    }

    public void setEnumcode(int enumcode) {
        this.enumcode = enumcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private int PageIndex;
        private int RecordCount;
        /**
         * Id : 2
         * VideoName : 测试视频2
         * FilePath : http://meist.meidp.com/upload/video/2.mp4
         * CreateTime : 2016-06-16 00:00:00
         * CreateUserId : 0
         * Remark : 测试数据2
         * Status : 1
         * FileSize : 4500
         * SortNo : 2
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

        public static class DataListBean implements Serializable {
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
}
