public class App {
    public static void main(String[] args) {
        System.out.println(SingletonLazy.getInstancia());
        System.out.println(SingletonEager.getInstancia());
        System.out.println(SingletonLazyHolder.getInstancia());
    }
}
