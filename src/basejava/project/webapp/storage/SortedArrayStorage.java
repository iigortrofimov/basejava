package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r, int index) {
        int sortedIndex = -index - 1;
        System.arraycopy(storage, sortedIndex, storage, sortedIndex + 1, size - sortedIndex);
        storage[sortedIndex] = r;
    }

    @Override
    public void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
