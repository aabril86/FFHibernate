package FF;

import FF.Entities.Personaje;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManagePersonaje {
    private static SessionFactory factory;

    public void addPersonaje(Personaje personaje){

        Session session = factory.openSession();
        Transaction tx = null;

        Integer PersonajeID = null;
        try {
            tx = session.beginTransaction();

            PersonajeID = (Integer) session.save(personaje);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listPersonajes(){

    }
}
