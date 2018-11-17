import basejava.project.webapp.model.Resume;
import basejava.project.webapp.storage.ArrayStorage;

/**
 * Test for your ArrayStoragee implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
       /* Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");*/
/*
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
       ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());*/

        Resume trofimov = new Resume();
        trofimov.setUuid("Trof");
        Resume petrov = new Resume();
        petrov.setUuid("Petrov");
        Resume orlov = new Resume();
        orlov.setUuid("Orlov");
        ARRAY_STORAGE.save(trofimov);
        ARRAY_STORAGE.save(petrov);
        ARRAY_STORAGE.save(orlov);
        printAll();
        System.out.println();
        ARRAY_STORAGE.delete("Petrov");
        ARRAY_STORAGE.delete("Orororo");
        //ARRAY_STORAGE.delete("Trof");
        printAll();

//        ARRAY_STORAGE.update(trofimov);
//        ARRAY_STORAGE.update(petrov);
//        ARRAY_STORAGE.get("Trof");
//        ARRAY_STORAGE.get("Orlov");
//        ARRAY_STORAGE.get("Orlsdsds");


    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
