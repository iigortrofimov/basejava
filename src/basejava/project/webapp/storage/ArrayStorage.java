package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    // update a resume if it is already in storage
    public void update(Resume r) {
        int x = check(r.getUuid());
        if (x != 0) {
            storage[x] = r;
        } else System.out.println("Resume not found");

    }


    // delete all resumes
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    //save new resume if it' s not in storage yet
    public void save(Resume r) {
        if (check(r.getUuid()) == 0) {
            for (int i = 0; i < storage.length; i++)
                if (storage[i] == null) {
                    storage[i] = r;
                    size++;
                    break;
                }
        } else System.out.println("Resume already added before");
    }

    // get an individual resume
    public Resume get(String uuid) {
        int x = check(uuid);
        if (x != 0) {
            return storage[x];
        } else System.out.println("Resume not found");
        return null;
    }


    // delete an individual resume
    public void delete(String uuid) {
        int x = check(uuid);
        if (x != 0) {
            for (int j = x; j < size - 1; j++) storage[x] = storage[x + 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Resume not found");

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    // return array of all resumes
    public Resume[] getAll() {
        Resume[] array = new Resume[size];
        for (int i = 0; i < size; i++) array[i] = storage[i];
        return array;
    }

    //return amount of resumes in storage
    public int size() {
        return size;
    }

    //check and return index in storage
    private int check(String uuid) {
        for (int i = 0; i < size; i++)
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStorage that = (ArrayStorage) o;
        return size == that.size &&
                Arrays.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }
}
