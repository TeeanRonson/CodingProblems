package SingletonPattern;


/**
 * Creating an enum Singleton will be thread safe
 */
public enum EnumSingleton {

    INSTANCE("Initial class info");

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }



    public static void main(String[] args) {


        EnumSingleton eSingleton1 = EnumSingleton.INSTANCE.getInstance();

        System.out.println(eSingleton1.getInfo());

        EnumSingleton eSingleton2 = EnumSingleton.INSTANCE.getInstance();
        eSingleton2.setInfo("New class info");

        System.out.println(eSingleton1.getInfo());
        System.out.println(eSingleton2.getInfo());





    }
}
