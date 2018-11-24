package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow!");
        } else if (getIndex(r.getUuid()) == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Resume: " + r.getUuid() + " already exist");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
