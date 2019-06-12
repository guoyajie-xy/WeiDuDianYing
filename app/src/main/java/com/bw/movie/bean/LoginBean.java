package com.bw.movie.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
@Entity
public class LoginBean {
    @Id
    public long id=1;
    public String sessionId;
    public String birthday;
    public String lastLoginTime;
    public String nickName;
    public String phone;
    public String sex;
    public String headPic;
    @Generated(hash = 1268079197)
    public LoginBean(long id, String sessionId, String birthday,
            String lastLoginTime, String nickName, String phone, String sex,
            String headPic) {
        this.id = id;
        this.sessionId = sessionId;
        this.birthday = birthday;
        this.lastLoginTime = lastLoginTime;
        this.nickName = nickName;
        this.phone = phone;
        this.sex = sex;
        this.headPic = headPic;
    }
    @Generated(hash = 1112702939)
    public LoginBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getLastLoginTime() {
        return this.lastLoginTime;
    }
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getHeadPic() {
        return this.headPic;
    }
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}

