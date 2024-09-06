package one;

import one.Vehicle.Car;
import one.Vehicle.Motocycle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car1 = new Car("Lada", "Largus", 2016, 200, 150000);
        car1.getId();
        car1.getManufacturer();
        car1.getModel();
        car1.getYear();
        car1.getSpeed();
        car1.getPrice();
        Motocycle motocycle1 = new Motocycle("Honda", "Sport", 2015, 300, 1500);
        motocycle1.getId();
        motocycle1.getManufacturer();
        motocycle1.getModel();
        motocycle1.getYear();
        motocycle1.getSpeed();
        motocycle1.getPrice();
//        session.save(car1);
//        session.save(motocycle1);
        transaction.commit();
//        session.flush();
        session.close();
        System.out.println("Transaction Completed !");
    }
}
