import java.lang.reflect.Field;

public class Ch4_9 {
    static class UniversalToString {
        public static String toString(Object obj) {
            StringBuilder sb = new StringBuilder();
            Class clazz = obj.getClass();
            for (Field f : clazz.getDeclaredFields()) {
                f.setAccessible(true);
                sb.append(f.getName());
                sb.append(":");
                try {
                    sb.append(f.get(obj));
                } catch (IllegalAccessException e) {
                    sb.append("unable to access");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    class A {
        private int x, y, z;

        public A(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return UniversalToString.toString(this);
        }
    }

    class B {
        private String a, b, c;

        public B(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return UniversalToString.toString(this);
        }
    }
}
