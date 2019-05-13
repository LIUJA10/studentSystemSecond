package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TBanji entity. @author MyEclipse Persistence Tools
 */

public class TBanji  implements java.io.Serializable {


    // Fields    

     private Integer class_id;
     private String mingcheng;
     private String del;



    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

   
    // Property accessors

    public String getMingcheng() {
        return this.mingcheng;
    }
    
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    public String getDel() {
        return this.del;
    }
    
    public void setDel(String del) {
        this.del = del;
    }


    @Override
    public String toString() {
        return "TBanji{" +
                "class_id=" + class_id +
                ", mingcheng='" + mingcheng + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}