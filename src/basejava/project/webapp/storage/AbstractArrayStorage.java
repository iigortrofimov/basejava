package basejava.project.webapp.storage;

import basejava.project.webapp.exception.StorageException;
import basejava.project.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> implements Storage {

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

    @Override
    protected void updateResume(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected void insertResume(Resume r, Integer index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow!", r.getUuid());
        } else {
            insertR(r, index);
            size++;
        }
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected void deleteResume(Integer index) {
        deleteR(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isSearchKeyExists(Integer searchKey) {
        return searchKey >= 0;
    }

    abstract protected Integer getSearchKey(String uuid);

    protected abstract void insertR(Resume r, int index);

    protected abstract void deleteR(int index);
}
