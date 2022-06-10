package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.database.dao.PersonDAO;
import people.handlers.html_render.Render;
import people.utils.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class HomeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model_data = new HashMap<>();
        model_data.put("menu", MainMenu.get());
        model_data.put("people", PersonDAO.getAll());
        if(context.queryParam("deletePerson") != null){
            model_data.put("deletePerson", context.queryParam("deletePerson"));
        }
        String html_content = Render.process("homepage.ftl", model_data);
        context.html(html_content);
    }
}
