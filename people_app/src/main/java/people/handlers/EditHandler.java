package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.database.dao.PersonDAO;
import people.handlers.html_render.Render;
import people.models.Person;
import people.utils.MainMenu;

import java.util.HashMap;

public class EditHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> model_data = new HashMap<>();
        model_data.put("menu", MainMenu.get());
        int persons_id = Integer.parseInt(context.pathParam("persons_id"));
        Person p = PersonDAO.get(persons_id);
        model_data.put("person", p);
        if(context.queryParam("editPerson") != null){
            model_data.put("editPerson", context.queryParam("editPerson"));
        }
        String html_content = Render.process("edit_person.ftl", model_data);
        context.html(html_content);
    }
}
