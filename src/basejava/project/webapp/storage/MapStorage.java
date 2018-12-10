package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.*;

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
    public List<Resume> getAll() {
        List<Resume> resumeList = new ArrayList<>(storage.values());
        Collections.sort(resumeList);
        return resumeList;
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
