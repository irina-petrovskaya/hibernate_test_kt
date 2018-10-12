import a.b.c.Tab2;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/12/2018.
 * Project: hibernate_test
 * *******************************
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType <?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                System.out.println("**********************************");
                System.out.println(entityName);
                System.out.println("**********************************");
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing default query: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                final Query q2 = session.getNamedQuery("myQuery1");
                System.out.println("executing named query: " + q2.getQueryString());
                for (Object o : q2.getResultList()) {
                    Tab2 t = (Tab2) o;
                    System.out.println("  " + t.toString());
                }

            }
        } finally {
            session.close();
        }
    }
}