package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.entrySet().toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        storage.remove(uuid);

    }

    @Override
    protected int getIndex(String uuid) {
        if (storage.containsKey(uuid)){
            return 1;
        }
            return -1;
    }

}
