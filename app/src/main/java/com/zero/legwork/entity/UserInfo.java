package com.zero.legwork.entity;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class UserInfo extends BaseResponseCode {

    private InfoEntity info;

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public static class InfoEntity {
        private String clerkEmail;
        private long clerkEmployDate;
        private String clerkName;
        private String clerkPhone;
        private String clerkPosition;
        private String deptId;
        private String id;

        public void setClerkEmail(String clerkEmail) {
            this.clerkEmail = clerkEmail;
        }

        public void setClerkEmployDate(long clerkEmployDate) {
            this.clerkEmployDate = clerkEmployDate;
        }

        public void setClerkName(String clerkName) {
            this.clerkName = clerkName;
        }

        public void setClerkPhone(String clerkPhone) {
            this.clerkPhone = clerkPhone;
        }

        public void setClerkPosition(String clerkPosition) {
            this.clerkPosition = clerkPosition;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getClerkEmail() {
            return clerkEmail;
        }

        public long getClerkEmployDate() {
            return clerkEmployDate;
        }

        public String getClerkName() {
            return clerkName;
        }

        public String getClerkPhone() {
            return clerkPhone;
        }

        public String getClerkPosition() {
            return clerkPosition;
        }

        public String getDeptId() {
            return deptId;
        }

        public String getId() {
            return id;
        }
    }
}
