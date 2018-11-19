package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    // update a resume if it is already in storage
    public void update(Resume r) {
        int index = check(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else System.out.println("Resume not found");

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    //save new resume if it' s not in storage yet
    public void save(Resume r) {
        if (size < storage.length) {
            if (check(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else System.out.println("Resume already added before");
        } else System.out.println("Storage is full");
    }

    public Resume get(String uuid) {
        int index = check(uuid);
        if (index >= 0) {
            return storage[index];
        } else System.out.println("Resume not found");
        return null;
    }

    public void delete(String uuid) {
        int index = check(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Resume not found");

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] array = new Resume[size];
        System.arraycopy(storage, 0, array, 0, size);
        return array;
    }

    public int size() {
        return size;
    }

    //check and return index in storage
    private int check(String uuid) {
        for (int i = 0; i < size; i++)
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        return -1;
    }
}
