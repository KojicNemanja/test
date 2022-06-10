package people.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import people.handlers.html_render.Render;
import people.utils.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class AddHandler implements Handler {

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model_data = new HashMap<>();
        model_data.put("menu", MainMenu.get());
        if(context.queryParam("savePerson") != null){
            model_data.put("savePerson", context.queryParam("savePerson"));
        }
        String html_content = Render.process("add_person.ftl", model_data);
        context.html(html_content);
    }
}
