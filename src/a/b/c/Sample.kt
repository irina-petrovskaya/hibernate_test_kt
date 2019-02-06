package a.b.c

import java.util.*
import javax.persistence.*

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/12/2018.
 * Project: hibernate_test
 * *******************************
 */
@Entity(name = "sample")
@Table(name = "sample", schema = "jbtests")
@NamedNativeQuery(name = "nativeQueryForSample", query = "select * from sample where version > 3", resultClass = Sample::class)
@NamedQuery(name = "namedQueryForSample", query = "select s from sample s where s.color = 'red'")
class Sample {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "version")
    var version: Int? = null
    @get:Basic
    @get:Column(name = "sample")
    var sample: String? = null
    @get:Basic
    @get:Column(name = "color")
    var color: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val sample1 = o as Sample?
        return id == sample1!!.id && version == sample1.version && sample == sample1.sample && color == sample1.color
    }

    override fun hashCode(): Int {
        return Objects.hash(id, version, sample, color)
    }

    override fun toString(): String {
        return "id=" + id + ", version=" + version + ", sample='" + sample + '\''.toString() + ", color='" + color + '\''.toString()
    }
}
