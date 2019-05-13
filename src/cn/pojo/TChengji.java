package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TChengji entity. @author MyEclipse Persistence Tools
 */

public class TChengji  implements java.io.Serializable {


    // Fields    

     private Integer chengji_id;
     private Integer xuesheng_id;
     private String kemu;
     private Integer fenshu;
     private Set<TXuesheng> students=new HashSet<TXuesheng>();

    public Set<TXuesheng> getStudents() {
        return students;
    }

    public void setStudents(Set<TXuesheng> students) {
        this.students = students;
    }


   
    // Property accessors


    public Integer getChengji_id() {
        return chengji_id;
    }

    public void setChengji_id(Integer chengji_id) {
        this.chengji_id = chengji_id;
    }

    public Integer getXuesheng_id() {
        return xuesheng_id;
    }

    public void setXuesheng_id(Integer xuesheng_id) {
        this.xuesheng_id = xuesheng_id;
    }

    public String getKemu() {
        return this.kemu;
    }
    
    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public Integer getFenshu() {
        return this.fenshu;
    }
    
    public void setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
    }


    @Override
    public String toString() {
        return "TChengji{" +
                "chengji_id=" + chengji_id +
                ", xuesheng_id=" + xuesheng_id +
                ", kemu='" + kemu + '\'' +
                ", fenshu=" + fenshu +
                ", students=" + students +
                '}';
    }
}