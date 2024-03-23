package pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {

    // 指定数据表中的主键
    @Id
    @GeneratedValue
    private int uid;
    private String name;
    private String address;

    public User(){

    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
