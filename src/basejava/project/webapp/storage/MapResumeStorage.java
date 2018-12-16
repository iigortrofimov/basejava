package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void insertResume(Resume r, Resume resume) {
        storage.put(resume.getUuid(), r);
    }

    @Override
    protected void deleteResume(Resume resume) {
        storage.remove(resume.getUuid());
    }

    @Override
    protected void updateResume(Resume r, Resume resume) {
        storage.put(resume.getUuid(), r);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isSearchKeyExists(Resume resume) {
        return resume != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
