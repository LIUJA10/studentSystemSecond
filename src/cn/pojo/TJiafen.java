package cn.pojo;


import java.util.HashSet;
import java.util.Set;

/**
 * TJiafen entity. @author MyEclipse Persistence Tools
 */

public class TJiafen  implements java.io.Serializable {


    // Fields    

     private Integer jiafen_id;
     private Integer xuesheng_id;
     private String xiangmu;
    private Integer fenzhi;

    private String shijian;
     private String beizhu;
    private Set<TXuesheng> students=new HashSet<TXuesheng>();


    public Set<TXuesheng> getStudents() {
        return students;
    }

    public void setStudents(Set<TXuesheng> students) {
        this.students = students;
    }


    public Integer getFenzhi() {
        return fenzhi;
    }

    public void setFenzhi(Integer fenzhi) {
        this.fenzhi = fenzhi;
    }

   
    // Property accessors

    public Integer getjiafen_id() {
        return this.jiafen_id;
    }
    
    public void setjiafen_id(Integer jiafen_id) {
        this.jiafen_id = jiafen_id;
    }


    public String getXiangmu() {
        return this.xiangmu;
    }

    public Integer getXuesheng_id() {
        return xuesheng_id;
    }

    public void setXuesheng_id(Integer xuesheng_id) {
        this.xuesheng_id = xuesheng_id;
    }

    public void setXiangmu(String xiangmu) {
        this.xiangmu = xiangmu;
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
        return "TJiafen{" +
                "jiafen_id=" + jiafen_id +
                ", xuesheng_id=" + xuesheng_id +
                ", xiangmu='" + xiangmu + '\'' +
                ", fenzhi=" + fenzhi +
                ", shijian='" + shijian + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", students=" + students +
                '}';
    }
}