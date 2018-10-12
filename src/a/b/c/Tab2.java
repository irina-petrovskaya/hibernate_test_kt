package a.b.c;

import javax.persistence.*;
import java.util.Objects;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/12/2018.
 * Project: hibernate_test
 * *******************************
 */
@Entity
@Table(name = "tab_2", schema = "jbtests")
@NamedQuery(name = "myQuery1", query = "select t from Tab2 t where t.age > 30")
public class Tab2 {
    private int id;
    private String name;
    private int age;
    private String leavingAddress;
    private String mobilePhoneNumber;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "LeavingAddress")
    public String getLeavingAddress() {
        return leavingAddress;
    }

    public void setLeavingAddress(String leavingAddress) {
        this.leavingAddress = leavingAddress;
    }

    @Basic
    @Column(name = "MobilePhoneNumber")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tab2 tab2 = (Tab2) o;
        return id == tab2.id && age == tab2.age && Objects.equals(name, tab2.name) && Objects.equals(leavingAddress, tab2.leavingAddress) && Objects.equals(mobilePhoneNumber, tab2.mobilePhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, leavingAddress, mobilePhoneNumber);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", leavingAddress='" + leavingAddress + '\'' + ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' + ' ';
    }
}
