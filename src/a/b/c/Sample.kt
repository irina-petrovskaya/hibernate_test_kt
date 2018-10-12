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
@Table(name = "sample", schema = "jbtests")
@NamedQuery(name = "myQuery2", query = "select s from Sample s where s.color = 'red'")
public class Sample {
    private int id;
    private Integer version;
    private String sample;
    private String color;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "sample")
    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample1 = (Sample) o;
        return id == sample1.id && Objects.equals(version, sample1.version) && Objects.equals(sample, sample1.sample) && Objects.equals(color, sample1.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, sample, color);
    }

    @Override
    public String toString() {
        return "id=" + id + ", version=" + version + ", sample='" + sample + '\'' + ", color='" + color + '\'' ;
    }
}
