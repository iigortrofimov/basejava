package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListStorageTest {
    private Storage storage = new ListStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String DUMMY = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final Resume DUMMY_RESUME = new Resume(DUMMY);

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void updateResume() {
        Resume newResume = new Resume(UUID_2);
        storage.update(newResume);
        assertSame(newResume, storage.get(newResume.getUuid()));
        assertEquals(3, storage.size());
    }

    @Test
    public void insertResume() {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertSame(RESUME_4, storage.get(RESUME_4.getUuid()));
    }

    @Test
    public void getResume() {
    }

    @Test
    public void deleteResume() {
    }

    @Test
    public void copyAllResumes() {
    }

    @Test
    public void isSearchKeyExists() {
    }

    @Test
    public void getSearchKey() {
    }
}