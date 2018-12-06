package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Resume r, String searchKey) {
        storage.replace(searchKey, r);
    }

    @Override
    protected void insertResume(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected Resume getResume(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void deleteResume(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected List<Resume> copyAllResumes() {
        return null;
    }

    @Override
    protected boolean isSearchKeyExists(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

}
