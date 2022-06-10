package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.database.dao.PersonDAO;
import people.handlers.html_render.Render;
import people.models.Person;
import people.utils.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class AddSubmitionHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("f_name");
        String last_name = context.formParam("l_name");
        String phone_number = context.formParam("phone_number");

        Person person = new Person(first_name, last_name, phone_number);

        PersonDAO.save(person);//save person
        if(person.getPersons_id() > 0){
            context.redirect("/add?savePerson=true");
        }else {
            context.redirect("/add?savePerson=false");
        }
    }
}
