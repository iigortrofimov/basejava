package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else {
            System.out.println("Resume: " + r.getUuid() + " not found");
        }
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume r) {
        int index = Math.abs(getIndex(r.getUuid())) - 1;
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow!");
        } else if (size == 0) {
            storage[size] = r;
            size++;
        } else if (getIndex(r.getUuid()) < 0) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = r;
            size++;
        } else {
            System.out.println("Resume: " + r.getUuid() + " already exist");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            storage[size] = null;
            size--;
        } else {
            System.out.println("Resume: " + uuid + " not found");
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
