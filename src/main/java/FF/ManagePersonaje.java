package FF;

import FF.Entities.Personaje;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Iterator;
import java.util.List;

public class ManagePersonaje {
    private static SessionFactory factory;

    public void afegirPersonatge(Personaje personaje){
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

    public void mostrarPersonatges(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List personatges = session.createQuery("FROM Personaje").list();

            for (Iterator iterator = personatges.iterator(); iterator.hasNext();) {
                Personaje personaje = (Personaje) iterator.next();
                System.out.println(personaje.toString());
            }

        }catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void borrarPersonatge(Integer PersonatgeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Personaje personaje = (Personaje) session.get(Personaje.class, PersonatgeID);
            session.delete(personaje);
            tx.commit();
        }catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
