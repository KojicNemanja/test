package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.database.dao.PersonDAO;
import people.models.Person;

public class DeleteHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int persons_id = Integer.parseInt(context.pathParam("persons_id"));
        Person p = PersonDAO.get(persons_id);
        if(p != null){
            int result = PersonDAO.delete(p);
            if(result > 0){
                context.redirect("/?deletePerson=true");
            }
        }else {
            context.redirect("/?deletePerson=false");
        }
    }
}
