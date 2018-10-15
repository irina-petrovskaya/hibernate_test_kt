package a.b.c

import java.util.*
import javax.persistence.*

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/12/2018.
 * Project: hibernate_test
 * *******************************
 */
@Entity
@Table(name = "tab_2", schema = "jbtests")
@NamedQuery(name = "namedQueryForTab2", query = "select t from Tab2 t where t.age > 30")
class Tab2 {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "name")
    var name: String? = null
    @get:Basic
    @get:Column(name = "age")
    var age: Int = 0
    @get:Basic
    @get:Column(name = "LeavingAddress")
    var leavingAddress: String? = null
    @get:Basic
    @get:Column(name = "MobilePhoneNumber")
    var mobilePhoneNumber: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val tab2 = o as Tab2?
        return id == tab2!!.id && age == tab2.age && name == tab2.name && leavingAddress == tab2.leavingAddress && mobilePhoneNumber == tab2.mobilePhoneNumber
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, age, leavingAddress, mobilePhoneNumber)
    }

    override fun toString(): String {
        return "id=" + id + ", name='" + name + '\''.toString() + ", age=" + age + ", leavingAddress='" + leavingAddress + '\''.toString() + ", mobilePhoneNumber='" + mobilePhoneNumber + '\''.toString() + ' '.toString()
    }
}
