package hiberutile;

import org.hibernate.SessionFactory;

public final class SessionFactoryProvider {

    private static final SessionFactory sessionFactory;

    // Bloc static pour garantir une seule initialisation
    static {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            System.err.println("Échec d'initialisation de la SessionFactory : " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    // Méthode pour récupérer la session factory unique
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Constructeur privé pour éviter l'instanciation
    private SessionFactoryProvider() {
    }
}
