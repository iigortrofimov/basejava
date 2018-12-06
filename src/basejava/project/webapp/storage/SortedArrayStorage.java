package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertR(Resume r, int index) {
        int sortedIndex = -index - 1;
        System.arraycopy(storage, sortedIndex, storage, sortedIndex + 1, size - sortedIndex);
        storage[sortedIndex] = r;
    }

    @Override
    public void deleteR(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
