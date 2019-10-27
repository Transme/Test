import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

public class validation {
    public static boolean validate(String username, String password){
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("lyw", "666");
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
