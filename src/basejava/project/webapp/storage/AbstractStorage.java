package basejava.project.webapp.storage;

import basejava.project.webapp.exception.ExistStorageException;
import basejava.project.webapp.exception.NotExistStorageException;
import basejava.project.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class AbstractStorage<E> implements Storage {

    protected abstract void updateResume(Resume r, E searchKey);

    protected abstract void insertResume(Resume r, E searchKey);

    protected abstract Resume getResume(E searchKey);

    protected abstract List<Resume> getAll();

    protected abstract void deleteResume(E searchKey);

    protected abstract boolean isSearchKeyExists(E searchKey);

    protected abstract E getSearchKey(String uuid);

    public void save(Resume r) {
        E searchKey = getNotExistSearchKey(r.getUuid());
        insertResume(r, searchKey);
    }

    public void delete(String uuid) {
        E searchKey = getExistSearchKey(uuid);
        deleteResume(searchKey);
    }

    public void update(Resume r) {
        E searchKey = getExistSearchKey(r.getUuid());
        updateResume(r, searchKey);
    }

    public Resume get(String uuid) {
        E searchKey = getExistSearchKey(uuid);
        return getResume(searchKey);
    }

    private E getExistSearchKey(String uuid) {
        E searchKey = getSearchKey(uuid);
        if (!isSearchKeyExists(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private E getNotExistSearchKey(String uuid) {
        E searchKey = getSearchKey(uuid);
        if (isSearchKeyExists(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }
}
