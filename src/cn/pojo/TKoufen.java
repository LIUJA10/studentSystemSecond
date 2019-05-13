package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TKoufen entity. @author MyEclipse Persistence Tools
 */

public class TKoufen  implements java.io.Serializable {


    // Fields    

     private Integer koufen_id;
     private Integer xuesheng_id;
     private String xiangmu;

    public Integer getXuesheng_id() {
        return xuesheng_id;
    }

    public void setXuesheng_id(Integer xuesheng_id) {
        this.xuesheng_id = xuesheng_id;
    }

    private Integer fenzhi;
     private Set<TXuesheng> students=new HashSet<TXuesheng>();
    private String shijian;
     private String beizhu;

    public Set<TXuesheng> getStudents() {
        return students;
    }

    public void setStudents(Set<TXuesheng> students) {
        this.students = students;
    }

   
    // Property accessors

    public Integer getkoufen_id() {
        return this.koufen_id;
    }
    
    public void setkoufen_id(Integer koufen_id) {
        this.koufen_id = koufen_id;
    }

    public String getXiangmu() {
        return this.xiangmu;
    }
    
    public void setXiangmu(String xiangmu) {
        this.xiangmu = xiangmu;
    }

    public Integer getFenzhi() {
        return this.fenzhi;
    }
    
    public void setFenzhi(Integer fenzhi) {
        this.fenzhi = fenzhi;
    }

    public String getShijian() {
        return this.shijian;
    }
    
    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }


    @Override
    public String toString() {
        return "TKoufen{" +
                "koufen_id=" + koufen_id +
                ", xuesheng_id=" + xuesheng_id +
                ", xiangmu='" + xiangmu + '\'' +
                ", fenzhi=" + fenzhi +
                ", students=" + students +
                ", shijian='" + shijian + '\'' +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}