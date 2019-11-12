package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context init");
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("name", strings);
        System.out.println(sc.getAttribute("name"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroy");
    }
}
