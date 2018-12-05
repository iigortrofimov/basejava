package basejava.project.webapp.storage;

import basejava.project.webapp.exception.ExistStorageException;
import basejava.project.webapp.exception.NotExistStorageException;
import basejava.project.webapp.exception.StorageException;
import basejava.project.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            updateResume(r, index);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else insertResume(r, index);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return getResume(index, uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            deleteResume(index, uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }


    protected abstract int getIndex(String uuid);

    protected abstract void updateResume(Resume r, int index);

    protected abstract void insertResume(Resume r, int index);

    protected abstract Resume getResume(int index, String uuid);

    protected abstract void deleteResume (int index, String uuid);
}
