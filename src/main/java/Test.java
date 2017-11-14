

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.Emp;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List <Emp>events = session.createQuery("from Emp").list();
        System.out.println("Jumlah Event = " + events.size());
        for (Emp event : events) {
            System.out.println("Event: " + event.getJob()+ "." + event.getEname());
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

	}

}
