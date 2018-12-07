package basejava.project.webapp.storage;

import basejava.project.webapp.exception.ExistStorageException;
import basejava.project.webapp.exception.NotExistStorageException;
import basejava.project.webapp.exception.StorageException;
import basejava.project.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static basejava.project.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.assertSame;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Unexpected StorageException");
        }
        storage.save(new Resume());
    }
}