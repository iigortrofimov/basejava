package basejava.project.webapp;

import basejava.project.webapp.model.Resume;
import basejava.project.webapp.storage.SortedArrayStorage;
import basejava.project.webapp.storage.Storage;

/**
 * Test for your ArrayStoragee implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {

        Resume trof = new Resume();
        Resume volk = new Resume();
        Resume petr = new Resume();
        ARRAY_STORAGE.save(trof);
        ARRAY_STORAGE.save(volk);
        ARRAY_STORAGE.save(petr);
        printAll();
        ARRAY_STORAGE.get("1234");
        ARRAY_STORAGE.delete("123");
        printAll();
        Resume sidr = new Resume();
        ARRAY_STORAGE.update(sidr);
        printAll();
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
