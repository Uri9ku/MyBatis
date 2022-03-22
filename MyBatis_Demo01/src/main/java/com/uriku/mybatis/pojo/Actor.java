package com.uriku.mybatis.pojo;

public class Actor {
    private Integer id;
    private String name;
    private String sex;
    private String borndate;
    private String phone;

    public Actor() {
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate='" + borndate + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBorndate() {
        return borndate;
    }

    public String getPhone() {
        return phone;
    }

    public Actor(Integer id, String name, String sex, String borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }
}
