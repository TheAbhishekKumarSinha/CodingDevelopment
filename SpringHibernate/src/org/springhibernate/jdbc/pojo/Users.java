package org.springhibernate.jdbc.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class Users {

    private String userid;
    private String username;
    private String password;
    private int unsuccessfulLoginAttempts;
    private String userLocked;
    private String userLockedReason;

    public Users() {

    }

    @XmlElement(name = "User_Name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement(name = "User_Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "User_Code")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @XmlElement(name = "UnSucessful_Attempts")
    public int getUnsuccessfulLoginAttempts() {
        return unsuccessfulLoginAttempts;
    }

    public void setUnsuccessfulLoginAttempts(int unsuccessfulLoginAttempts) {
        this.unsuccessfulLoginAttempts = unsuccessfulLoginAttempts;
    }

    @XmlElement(name = "User_Locked")
    public String getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(String userLocked) {
        this.userLocked = userLocked;
    }

    @XmlElement(name = "User_Locked_Reason")
    public String getUserLockedReason() {
        return userLockedReason;
    }

    public void setUserLockedReason(String userLockedReason) {
        this.userLockedReason = userLockedReason;
    }

}
