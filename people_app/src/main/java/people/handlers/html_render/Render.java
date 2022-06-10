package people.handlers.html_render;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import people.templating.FreeMarkerConfiguration;

import java.io.IOException;
import java.io.StringWriter;

public class Render {

    public static String process(String template_name, Object model_data) throws IOException, TemplateException {
        Template template = FreeMarkerConfiguration.get().getTemplate(template_name);
        StringWriter writer = new StringWriter();
        template.process(model_data, writer);
        return writer.toString();
    }

    public static String process(String template_name) throws IOException, TemplateException {
        return process(null, template_name);
    }
}
