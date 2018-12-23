package basejava.project.webapp;


import basejava.project.webapp.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
//        Singleton[] singletons =Singleton.values();
//        System.out.println(Arrays.toString(singletons));
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.name());
        System.out.println(instance.ordinal()); // serial number
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton {
        INSTANCE
    }
}
