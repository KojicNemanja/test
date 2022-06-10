package people.database.dao;

import org.hibernate.Session;
import people.database.HibernateUtil;
import people.models.Person;
import java.util.List;

public class PersonDAO {

    public static int save(Person p){
        try {
            Session session = HibernateUtil.getSession();
            session.getTransaction().begin();
            session.persist(p);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }finally {
            HibernateUtil.closeSession();
        }
        return p.getPersons_id();//return generated id
    }

    public static Person get(int persons_id){
        Session session = null;
        Person p = null;
        try{
            session = HibernateUtil.getSession();
            session.getTransaction().begin();
            String query = """
                    SELECT p FROM Person p
                    WHERE p.persons_id = :presons_id""";
            p = session.createQuery(query, Person.class)
                    .setParameter("presons_id", persons_id).getSingleResult();
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return p;
    }

    public static List<Person> getAll(){
        Session session = null;
        List<Person> p = null;
        try{
            session = HibernateUtil.getSession();
            session.getTransaction().begin();
            p = session.createQuery("FROM Person", Person.class)
                            .getResultList();
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return p;
    }

    public static int edit(Person p){
        try {
            Session session = HibernateUtil.getSession();
            session.getTransaction().begin();
            session.merge(p);
            /*int result = session.createQuery("update Person p" +
                    "set p.first_name = :new_firstName " +
                    "where p.persons_id = :persons_id ", Person.class)
                    .setParameter("new_firstName", p.getFirst_name())
                    .setParameter("persons_id", p.getPersons_id())
                    .executeUpdate();*/
            session.getTransaction().commit();
            return p.getPersons_id();
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    public static int delete(Person p){
        int result = 0;
        try {
            Session session = HibernateUtil.getSession();
            session.getTransaction().begin();
            session.remove(p);
            /*int result = session.createQuery("delete Person p" +
                    "where p.persons_id = :persons_id ", Person.class)
                    .setParameter("persons_id", persons_id)
                    .executeUpdate();*/
            session.getTransaction().commit();
            result = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    public static int delete(int persons_id){
        Person p = new Person();
        p.setPersons_id(persons_id);
        return delete(p);
    }
}
