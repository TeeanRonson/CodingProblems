package SingletonPattern;


/**
 * The above implementation works fine incase of single threaded environment but when it comes to multithreaded systems,
 * it can cause issues if multiple threads are inside the if loop at the same time.
 *
 * It will destroy the singleton pattern and both threads will get the different instances of singleton class.
 *
 * In next section, we will see different ways to create a thread-safe singleton class.
 */
public class Singleton {

    private static Singleton INSTANCE;
    private String info;

    /**
     * Note that the constructor is private
     */
    private Singleton() {
        this.info = "Initial info";

    }

    public static Singleton getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;

    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }



    /**
     * While this is a common approach, it’s important to note that it can be problematic in multithreading scenarios,
     * which is the main reason for using Singletons.
     * Simply put, it can result in more than one instance, breaking the pattern’s core principle.
     *
     * Although there are locking solutions to this problem, our next approach solves these problems at a root level.
     *
     */
    public static void main(String[] args) {

        Singleton single1 = Singleton.getInstance();

        System.out.println(single1.getInfo());

        Singleton single2 = Singleton.getInstance();
        single2.setInfo("New Info");
        System.out.println(single1.getInfo());
        System.out.println(single2.getInfo());



    }
}
