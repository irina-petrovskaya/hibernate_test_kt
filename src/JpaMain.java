import a.b.c.Sample;
import a.b.c.Tab2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaMain {

    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        EntityManager entitymanager = factory.createEntityManager();
        entitymanager.getTransaction().begin();
// Find the number of objects in the database:
        Query count = entitymanager.createQuery("SELECT count(s) FROM Sample s");
        final Long result = (Long) count.getSingleResult();
        int rez = Math.toIntExact(result + 1);
        System.out.println(result);
        Sample sample = new Sample();
        sample.setId(rez);
        sample.setSample("sample" + rez);
        sample.setColor("red");
        sample.setVersion(1);
        entitymanager.persist(sample);
        entitymanager.getTransaction().commit();


        Query namedQuery2 = entitymanager.createNamedQuery("myQuery2");
        System.out.println("**********************************");
        System.out.println("executing the named query from Sample");
        System.out.println("**********************************");
        for (Object o : namedQuery2.getResultList()) {
            Sample s = (Sample) o;
            System.out.println(s.toString());
        }
        Query namedQuery1 = entitymanager.createNamedQuery("myQuery1");
        System.out.println("**********************************");
        System.out.println("executing the named query from Tab2");
        System.out.println("**********************************");
        for (Object o : namedQuery1.getResultList()) {
            Tab2 s = (Tab2) o;
            System.out.println(s.toString());
        }
        Query nativeQuery1 = entitymanager.createNamedQuery("nativeQueryForSample");
        System.out.println("**********************************");
        System.out.println("executing the native query from Sample");
        System.out.println("**********************************");
        for (Object o : nativeQuery1.getResultList()) {
            Sample s = (Sample) o;
            System.out.println(s.toString());
        }
        // Close the database connection:
        entitymanager.close();
        factory.close();
    }

}
