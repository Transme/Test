import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import java.io.File;

public class InnerTomcat {
    public void startTomcat(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Service service = tomcat.getService();
        Connector connector = new Connector();
        connector.setPort(8080);
        service.addConnector(connector);

        Host host = tomcat.getHost();
        host.setName("localhost");
        host.setAppBase("webapp");

        String appBase = System.getProperty("user.dir") +
                File.separator + "src\\main\\webapp";
        String contextPath = "";

        Context context = tomcat.addWebapp(contextPath,appBase);

        if(context instanceof StandardContext){
            StandardContext sc = (StandardContext)context;
            sc.setDefaultContextXml(appBase + File.separator + "WEB-INF\\web.xml");
            Wrapper wrapper = tomcat.addServlet(contextPath, "DemoServlet", new DemoServlet());
            wrapper.addMapping("/DemoServlet");
        }
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        tomcat.getServer().await();
    }

    public static void main(String[] args){
        new InnerTomcat().startTomcat();
    }
}
