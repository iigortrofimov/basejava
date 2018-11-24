package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveResume(Resume r) {
        if (getIndex(r.getUuid()) < 0) {
            int index = Math.abs(getIndex(r.getUuid())) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = r;
            size++;
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
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
