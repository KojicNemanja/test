package people;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import people.handlers.*;

public class Program {
    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.addStaticFiles(System.getenv("JAVA_RESOURCES") + "/people_web_app/static", Location.EXTERNAL);
        });
        app.get("/", new HomeHandler());
        app.get("/add", new AddHandler());
        app.post("/add", new AddSubmitionHandler());
        app.get("/edit/{persons_id}", new EditHandler());
        app.post("/edit/{persons_id}", new EditSubmitionHandler());
        app.get("/delete/{persons_id}", new DeleteHandler());
        app.start(8080);
    }
}
