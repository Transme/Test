import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) {
        Class<?> classes = validation.class;
        Method[] methods = classes.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
}
