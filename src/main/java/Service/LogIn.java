package Service;

import Bean.User;
import DAO.userDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ArrayList<String> names = (ArrayList<String>) req.getServletContext().getAttribute("name");
        for(String each : names){
            System.out.println(each);
        }
//        System.out.println(req.getServletContext().getAttribute("name"));
        User user = new User(username, password);
        List<User> users = userDAO.RetrieveAll();
        PrintWriter writer = resp.getWriter();
        for(User each : users){
            if(each.equals(user)){
                writer.println("<h1>登录成功</h1><hr>");
                return;
            }
        }
        writer.println("<h1>登录失败</h1><hr>");
    }
}
