/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; storage[i] != null; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }
    
    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            } else {
                if (storage[i].uuid == uuid) {
                    for (int j = i; j < storage.length - 1; j++) {
                        storage[j] = storage[j + 1];
                    }
                    storage[storage.length - 1] = null;
                    size--;
                }
            }
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = 0;
        for (int i = 0; storage[i] != null; i++) {
            size++;
        }
        Resume[] array = new Resume[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = storage[i];
        }
        return array;
    }

    int size() {
        return size;
    }
}
