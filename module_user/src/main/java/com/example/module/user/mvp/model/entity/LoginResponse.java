package com.example.module.user.mvp.model.entity;

import java.io.Serializable;


public class LoginResponse   implements Serializable {



    /**
     * userInfo : {"id":26131,"realName":"罗鹏","nickName":"","email":"","sex":1,"phone":"15250441365","avatar":null,"companyName":"均瑶科创","openId":"20180606095944433880","remark":"","deleted":"N","userToken":"de6d0000e2ee0503d673d375412de895","position":"","redbagAuth":null,"userConfigInfo":{"id":26793,"userId":26131,"redBagTag":0,"shrbPersonUnionID":"kZELOaJItiB8HVy+mAUzMQ===","gagTag":0,"donateTag":null,"seeLive":0},"createTime":"2018-06-05 18:37:15"}
     * deviceVersion : {"id":2,"minVersion":"7","latestVersion":"7","deviceOs":"android","downloadURL":"http://windfindtech-1255850199.file.myqcloud.com/device/JuneYaoAPP.apk","downloadPage":"http://windfindtech-1255850199.file.myqcloud.com/JuneYaoAPP.apk","createTime":"2018-01-11 17:16:11","deleted":"N"}
     */

    private UserInfoBean userInfo;
    private DeviceVersionBean deviceVersion;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public DeviceVersionBean getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(DeviceVersionBean deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public static class UserInfoBean {
        /**
         * id : 26131
         * realName : 罗鹏
         * nickName :
         * email :
         * sex : 1
         * phone : 15250441365
         * avatar : null
         * companyName : 均瑶科创
         * openId : 20180606095944433880
         * remark :
         * deleted : N
         * userToken : de6d0000e2ee0503d673d375412de895
         * position :
         * redbagAuth : null
         * userConfigInfo : {"id":26793,"userId":26131,"redBagTag":0,"shrbPersonUnionID":"kZELOaJItiB8HVy+mAUzMQ===","gagTag":0,"donateTag":null,"seeLive":0}
         * createTime : 2018-06-05 18:37:15
         */

        private int id;
        private String realName;
        private String nickName;
        private String email;
        private int sex;
        private String phone;
        private Object avatar;
        private String companyName;
        private String openId;
        private String remark;
        private String deleted;
        private String userToken;
        private String position;
        private Object redbagAuth;
        private UserConfigInfoBean userConfigInfo;
        private String createTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Object getRedbagAuth() {
            return redbagAuth;
        }

        public void setRedbagAuth(Object redbagAuth) {
            this.redbagAuth = redbagAuth;
        }

        public UserConfigInfoBean getUserConfigInfo() {
            return userConfigInfo;
        }

        public void setUserConfigInfo(UserConfigInfoBean userConfigInfo) {
            this.userConfigInfo = userConfigInfo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public static class UserConfigInfoBean {
            /**
             * id : 26793
             * userId : 26131
             * redBagTag : 0
             * shrbPersonUnionID : kZELOaJItiB8HVy+mAUzMQ===
             * gagTag : 0
             * donateTag : null
             * seeLive : 0
             */

            private int id;
            private int userId;
            private int redBagTag;
            private String shrbPersonUnionID;
            private int gagTag;
            private Object donateTag;
            private int seeLive;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getRedBagTag() {
                return redBagTag;
            }

            public void setRedBagTag(int redBagTag) {
                this.redBagTag = redBagTag;
            }

            public String getShrbPersonUnionID() {
                return shrbPersonUnionID;
            }

            public void setShrbPersonUnionID(String shrbPersonUnionID) {
                this.shrbPersonUnionID = shrbPersonUnionID;
            }

            public int getGagTag() {
                return gagTag;
            }

            public void setGagTag(int gagTag) {
                this.gagTag = gagTag;
            }

            public Object getDonateTag() {
                return donateTag;
            }

            public void setDonateTag(Object donateTag) {
                this.donateTag = donateTag;
            }

            public int getSeeLive() {
                return seeLive;
            }

            public void setSeeLive(int seeLive) {
                this.seeLive = seeLive;
            }
        }
    }

    public static class DeviceVersionBean {
        /**
         * id : 2
         * minVersion : 7
         * latestVersion : 7
         * deviceOs : android
         * downloadURL : http://windfindtech-1255850199.file.myqcloud.com/device/JuneYaoAPP.apk
         * downloadPage : http://windfindtech-1255850199.file.myqcloud.com/JuneYaoAPP.apk
         * createTime : 2018-01-11 17:16:11
         * deleted : N
         */

        private int id;
        private String minVersion;
        private String latestVersion;
        private String deviceOs;
        private String downloadURL;
        private String downloadPage;
        private String createTime;
        private String deleted;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMinVersion() {
            return minVersion;
        }

        public void setMinVersion(String minVersion) {
            this.minVersion = minVersion;
        }

        public String getLatestVersion() {
            return latestVersion;
        }

        public void setLatestVersion(String latestVersion) {
            this.latestVersion = latestVersion;
        }

        public String getDeviceOs() {
            return deviceOs;
        }

        public void setDeviceOs(String deviceOs) {
            this.deviceOs = deviceOs;
        }

        public String getDownloadURL() {
            return downloadURL;
        }

        public void setDownloadURL(String downloadURL) {
            this.downloadURL = downloadURL;
        }

        public String getDownloadPage() {
            return downloadPage;
        }

        public void setDownloadPage(String downloadPage) {
            this.downloadPage = downloadPage;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }
    }
}
