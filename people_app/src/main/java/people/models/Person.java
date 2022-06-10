package people.models;

import jakarta.persistence.*;

@Entity
@Table(name="person")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int persons_id;

    private String first_name;

    private String last_name;

    private String phone_number;

    public Person() {}

    public Person(String first_name, String last_name, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    public int getPersons_id() {
        return persons_id;
    }

    public void setPersons_id(int persons_id) {
        this.persons_id = persons_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "persons_id=" + persons_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
