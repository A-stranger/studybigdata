package cn.studybigdata.java.jvm;

public class MethodStackJVM {
    public static final int intData = 666;
    public static User user = new User();

    public double compute() {
        int a = 1;
        float b = 2;
        double c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {

        MethodStackJVM methodStackJVM = new MethodStackJVM();
        methodStackJVM.compute();
    }
}
