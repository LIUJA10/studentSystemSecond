package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TXuesheng entity. @author MyEclipse Persistence Tools
 */

public class TXuesheng  implements java.io.Serializable {


    // Fields
    private  Set<TJiafen> jiafens=new HashSet<TJiafen>();
    private Set<TKoufen> koufens=new HashSet<TKoufen>();
    private Set<TChengji> chengjis=new HashSet<TChengji>();
    private TBanji tBanji;
     private Integer xs_id;

    public TBanji gettBanji() {
        return tBanji;
    }

    public void settBanji(TBanji tBanji) {
        this.tBanji = tBanji;
    }

    private Integer banji_id;

    public Set<TChengji> getChengjis() {
        return chengjis;
    }

    public void setChengjis(Set<TChengji> chengjis) {
        this.chengjis = chengjis;
    }

    private String xuehao;
     private String userName;

    public Set<TJiafen> getJiafens() {
        return jiafens;
    }

    public void setJiafens(Set<TJiafen> jiafens) {
        this.jiafens = jiafens;
    }

    public Set<TKoufen> getKoufens() {
        return koufens;
    }

    public void setKoufens(Set<TKoufen> koufens) {
        this.koufens = koufens;
    }

    private String xingbie;
     private String nianling;
     private String userPw;
     private String del;
   
    // Property accessors

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public Integer getXs_id() {
        return xs_id;
    }

    public void setXs_id(Integer xs_id) {
        this.xs_id = xs_id;
    }

    public Integer getBanji_id() {
        return banji_id;
    }

    public void setBanji_id(Integer banji_id) {
        this.banji_id = banji_id;
    }

    public String getXuehao() {
        return this.xuehao;
    }
    
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getXingbie() {
        return this.xingbie;
    }
    
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public String getNianling() {
        return this.nianling;
    }
    
    public void setNianling(String nianling) {
        this.nianling = nianling;
    }

    public String getDel() {
        return this.del;
    }
    
    public void setDel(String del) {
        this.del = del;
    }


    @Override
    public String toString() {
        return "TXuesheng{" +
                "jiafens=" + jiafens +
                ", koufens=" + koufens +
                ", chengjis=" + chengjis +
                ", tBanji=" + tBanji +
                ", xs_id=" + xs_id +
                ", banji_id=" + banji_id +
                ", xuehao='" + xuehao + '\'' +
                ", userName='" + userName + '\'' +
                ", xingbie='" + xingbie + '\'' +
                ", nianling='" + nianling + '\'' +
                ", userPw='" + userPw + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}