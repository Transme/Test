import Bean.User;
import DAO.userDAO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

import java.util.List;

public class validation {
    private static SimpleAccountRealm realm = new SimpleAccountRealm();
    static{
        List<User> users = userDAO.RetrieveAll();
        for(User user : users){
            realm.addAccount(user.getUsername(), user.getPassword());
        }
    }

    public static void addAccount(User user){
        realm.addAccount(user.getUsername(), user.getPassword());
    }

    public static boolean validate(String username, String password){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);

        if(subject.isAuthenticated()){
            return true;
        }
        else{
            return false;
        }
    }
}
