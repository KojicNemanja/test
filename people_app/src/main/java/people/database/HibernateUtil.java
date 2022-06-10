package people.database;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import people.models.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private static SessionFactory createSessionFactory() throws FileNotFoundException {
        if(sessionFactory != null) return sessionFactory;

        String dbConfig_path = System.getenv("JAVA_RESOURCES") + "/people_web_app/configuration/database.json";
        Gson gson = new Gson();

        FileReader reader = new FileReader(new File(dbConfig_path));
        DBConfiguration dbc = gson.fromJson(reader, DBConfiguration.class);

        HashMap<String, Object> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
        settings.put("hibernate.connection.url",String.format(
                "jdbc:mysql://%s/%s", dbc.getHost(), dbc.getDatabase()));
        settings.put("hibernate.connection.username", dbc.getUsername());
        settings.put("hibernate.connection.password", dbc.getPassword());
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Person.class);

        Metadata metadata = metadataSources.buildMetadata();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() throws FileNotFoundException {
        return createSessionFactory();
    }

    public static Session getSession() throws FileNotFoundException {
        if(session != null) return session;
        return getSessionFactory().openSession();
    }

    public static void closeSession(){
        if(session != null) {
            session.close();
            session = null;
        }
    }

    public static void closeSessionFactory(){
        closeSession();
        if(sessionFactory != null){
            sessionFactory.close();
            sessionFactory = null;
        }
    }
}
