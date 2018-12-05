package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();


    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.add(index, r);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storage.add(r);
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        storage.remove(index);
    }


    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
