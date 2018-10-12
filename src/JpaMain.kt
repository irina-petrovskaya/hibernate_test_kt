import a.b.c.Sample
import javax.persistence.Persistence

object JpaMain {

    @JvmStatic
    fun main(args: Array<String>) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        val factory = Persistence.createEntityManagerFactory("NewPersistenceUnit")

        val entitymanager = factory.createEntityManager()
        entitymanager.transaction.begin()
        // Find the number of objects in the database:
        val count = entitymanager.createQuery("SELECT count(s) FROM Sample s")
        val result = count.singleResult as Long
        val rez = Math.toIntExact(result + 1)
        println(result)
        val sample = Sample()
        sample.id = rez
        sample.sample = "sample$rez"
        sample.color = "red"
        sample.version = 1
        entitymanager.persist(sample)
        entitymanager.transaction.commit()


        val namedQuery = entitymanager.createNamedQuery("myQuery2")
        println("**********************************")
        println("executing the named query")
        println("**********************************")
        for (o in namedQuery.resultList) {
            val s = o as Sample
            println(s.toString())
        }
        // Close the database connection:
        entitymanager.close()
        factory.close()
    }

}
