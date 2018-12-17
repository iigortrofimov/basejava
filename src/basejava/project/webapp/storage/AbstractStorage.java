package basejava.project.webapp.storage;

import basejava.project.webapp.exception.ExistStorageException;
import basejava.project.webapp.exception.NotExistStorageException;
import basejava.project.webapp.model.Resume;

import java.util.Collections;
import java.util.List;


public abstract class AbstractStorage<SK> implements Storage {

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    public void save(Resume resume) {
        SK searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public void update(Resume resume) {
        SK searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    private SK getExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }
}
