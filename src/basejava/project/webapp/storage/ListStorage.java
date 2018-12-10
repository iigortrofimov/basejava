package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    protected void updateResume(Resume r, Integer searchKey) {
        resumeList.set(searchKey, r);
    }

    @Override
    protected void insertResume(Resume r, Integer searchKey) {
        resumeList.add(r);
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return resumeList.get(searchKey);
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        resumeList.remove(searchKey.intValue());
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(resumeList);
    }

    @Override
    protected boolean isSearchKeyExists(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
