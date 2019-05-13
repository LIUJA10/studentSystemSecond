package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class TAdmin  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String userPw;
   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return this.userPw;
    }
    
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    @Override
    public String toString() {
        return "TAdmin[userId="+userId+",userName="+userName+",userPw="+userPw+"]";
    }
}