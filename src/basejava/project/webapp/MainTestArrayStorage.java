package basejava.project.webapp;

import basejava.project.webapp.model.Resume;
import basejava.project.webapp.storage.ArrayStorage;

/**
 * Test for your ArrayStoragee implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {

        Resume trof = new Resume();
        trof.setUuid("123");
        Resume volk = new Resume();
        volk.setUuid("1234");
        Resume petr = new Resume();
        petr.setUuid("12345");
        ARRAY_STORAGE.save(trof);
        ARRAY_STORAGE.save(volk);
        ARRAY_STORAGE.save(petr);
        printAll();
        ARRAY_STORAGE.get("1234");
        ARRAY_STORAGE.delete("123");
        printAll();
        Resume sidr = new Resume();
        sidr.setUuid("1234");
        ARRAY_STORAGE.update(sidr);
        printAll();
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
