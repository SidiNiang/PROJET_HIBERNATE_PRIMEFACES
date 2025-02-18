package bdbeans;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Chargement de la configuration Hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Création de la première personne
            Personne personne1 = new Personne();
            personne1.setNom("Papi");
            personne1.setPrenom("Niang");
            personne1.setAge(28);
            personne1.setAdresse("Grand Yoff");
            personne1.setLogin("papiniang");
            personne1.setMotdepasse("momo001");
            // Enregistrement de la personne dans la base
            session.save(personne1);

            // Validation de la transaction
            transaction.commit();
            System.out.println("Données enregistrées avec succès !");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
