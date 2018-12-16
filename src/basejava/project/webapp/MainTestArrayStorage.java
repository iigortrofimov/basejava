package basejava.project.webapp;

import basejava.project.webapp.model.Resume;
import basejava.project.webapp.storage.MapResumeStorage;
import basejava.project.webapp.storage.SortedArrayStorage;
import basejava.project.webapp.storage.Storage;

/**
 * Test for your ArrayStoragee implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new MapResumeStorage();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String FULL_NAME1 = "fullName1";
    private static final String FULL_NAME2 = "fullName2";
    private static final String FULL_NAME3 = "fullName3";
    private static final String FULL_NAME4 = "fullName4";
    private static final String DUMMY = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1, FULL_NAME1);
    private static final Resume RESUME_2 = new Resume(UUID_2, FULL_NAME2);
    private static final Resume RESUME_3 = new Resume(UUID_3, FULL_NAME3);
    private static final Resume RESUME_4 = new Resume(UUID_4, FULL_NAME4);
    private static final Resume DUMMY_RESUME = new Resume(DUMMY);

    public static void main(String[] args) {
       ARRAY_STORAGE.save(RESUME_1);
       ARRAY_STORAGE.save(RESUME_2);
       ARRAY_STORAGE.save(RESUME_3);
        System.out.println(ARRAY_STORAGE);
       // printAll();
    }

    private static void printAll() {
        System.out.println("\nGet All Sorted");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
