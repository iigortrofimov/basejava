package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

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
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
