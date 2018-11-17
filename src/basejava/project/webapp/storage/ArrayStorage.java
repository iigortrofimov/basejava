package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void update(Resume r) {
        if (check(r) == r) {
            for (int i = 0; i < size; i++)
                if (r.getUuid() == storage[i].getUuid()) {
                    storage[i] = r;
                }
        } else System.out.println("Resume not found");
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    public void save(Resume r) {
        if (check(r) != r) {
            for (int i = 0; i < storage.length; i++)
                if (storage[i] == null) {
                    storage[i] = r;
                    size++;
                    break;
                }
        } else System.out.println("Resume already added before");
    }

    public Resume get(String uuid) {
        if (check(uuid) == uuid) {
            for (int i = 0; i < size; i++)
                if (check(uuid) == storage[i].getUuid())
                    if (storage[i].getUuid() == uuid) {
                        return storage[i];
                    }
        } else System.out.println("Resume not found");
        return null;
    }


    public void delete(String uuid) {
        if (check(uuid) == uuid) {
            for (int i = 0; i < size; i++)
                if (storage[i] == null) {
                    break;
                } else {
                    if (storage[i].getUuid() == uuid) {
                        for (int j = i; j < size - 1; j++) storage[j] = storage[j + 1];
                        storage[size - 1] = null;
                        size--;
                    }
                }
        }else System.out.println("Resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] array = new Resume[size];
        for (int i = 0; i < size; i++) array[i] = storage[i];
        return array;
    }

    public int size() {
        return size;
    }

    private Resume check(Resume r) {
        for (int i = 0; i < size; i++)
            if (r.getUuid() == storage[i].getUuid()) {
                return r;
            }
        return null;
    }

    private String check(String uuid) {
        for (int i = 0; i < size; i++)
            if (uuid == storage[i].getUuid()) {
                return uuid;
            }
        return null;
    }


}
