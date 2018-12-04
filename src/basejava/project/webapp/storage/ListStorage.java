package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage.add(index, r);
        }
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) {
        storage.add(r);
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    public void delete(String uuid) {
        storage.remove(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
