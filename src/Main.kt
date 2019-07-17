import a.b.c.Sample
import a.b.c.Tab2
import org.hibernate.HibernateException
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/12/2018.
 * Project: hibernate_test
 * *******************************
 */
object Main {
    private val ourSessionFactory: SessionFactory

    val session: Session
        @Throws(HibernateException::class)
        get() = ourSessionFactory.openSession()

    init {
        try {
            val configuration = Configuration()
            configuration.configure()

            ourSessionFactory = configuration.buildSessionFactory()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }

    }

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val session = session
        try {
            println("querying all the managed entities...")
            val metamodel = session.sessionFactory.metamodel
            for (entityType in metamodel.entities) {
                val entityName = entityType.name
                println("**********************************")
                println(entityName)
                println("**********************************")
                val query = session.createQuery("from $entityName")
                println("executing default query: " + query.queryString)
                for (o in query.list()) {
                    println("  $o")
                }

            }
            println("****************************************")
            println("********   test named queries   ********")
            println("****************************************")
            val q2 = session.getNamedQuery("namedQueryForTab2")
            println("executing named query: " + q2.queryString)
            for (o in q2.resultList) {
                val t = o as Tab2
                println("  " + t.toString())
            }
            val q3 = session.getNamedQuery("namedQueryForSample")
            println("executing named query: " + q3.queryString)
            for (o in q3.resultList) {
                val s = o as Sample
                println("  " + s.toString())
            }
            val q4 = session.getNamedQuery("nativeQueryForSample")
            println("executing native query: " + q4.queryString)
            for (o in q4.resultList) {
                val s = o as Sample
                println("  " + s.toString())
            }
        } finally {
            session.close()
        }
    }
}
