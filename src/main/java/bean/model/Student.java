package bean.model;

import java.sql.Date;

/**
 * Created by t on 2016/12/30.
 */
public class Student {
    int sno;
    String sname;
    String sex;
    int age;
    String identify;
    String tel;
    String carType;
    Date enrollTime;
    Date leaveTime;
    String scondition;
    String text;
    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getScondition() {
        return scondition;
    }

    public void setScondition(String scondition) {
        this.scondition = scondition;
    }


    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }







    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }





    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Student(){}
}
