package basejava.project.webapp.storage;

import basejava.project.webapp.exception.ExistStorageException;
import basejava.project.webapp.exception.NotExistStorageException;
import basejava.project.webapp.exception.StorageException;
import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected void insertResume(Resume r, int index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow!", r.getUuid());
        } else {
            insertR(r, index);
            size++;
        }
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage[index];
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        deleteR(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void insertR(Resume r, int index);

    protected abstract void deleteR (int index);
}
