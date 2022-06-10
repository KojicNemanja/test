package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.database.dao.PersonDAO;
import people.models.Person;

public class EditSubmitionHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int persons_id = Integer.parseInt(context.pathParam("persons_id"));
        String first_name = context.formParam("f_name");
        String last_name = context.formParam("l_name");
        String phone_number = context.formParam("phone_number");

        Person p = PersonDAO.get(persons_id);
        p.setFirst_name(first_name);
        p.setLast_name(last_name);
        p.setPhone_number(phone_number);
        int result = PersonDAO.edit(p);
        if (result > 0){
            context.redirect(String.format("/edit/%s?editPerson=true", persons_id));
        }else {
            context.redirect(String.format("/edit/%s?editPerson=false", persons_id));
        }
    }
}
