import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ch4_11 {
    public static final String message = "Hello, World!";

    public static void main(String... args) {
        try {
            Class clazz = Class.forName("java.lang.System");
            Field out = clazz.getDeclaredField("out");
            Class<?> outPs = out.getType();
            Method println = outPs.getMethod("println", String.class);
            println.invoke(out.get(null), message);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
