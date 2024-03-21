package pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "class_contact")
public class Contact {

    @Id
    private int id;

    @Embedded
    private Name name;

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @Column(name = "addr")
    private String address;

    @ElementCollection
    @JoinTable(name = "contact_phones",joinColumns = @JoinColumn(name = "contact_id"))
    private List<String> phones = new ArrayList<>();

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    @ElementCollection
    private Map<Integer,String> map = new HashMap<>();

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Contact() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
