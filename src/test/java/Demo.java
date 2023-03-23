public class Demo {


    public static void main(String[] args) {


        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.dir"));


        System.setProperty("browser", "firefox");

        System.out.println(System.getProperty("browser"));
    }
}
