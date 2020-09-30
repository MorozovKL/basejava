/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = size();
    }

    void save(Resume r) {
        int i = size;
        if (i != 10000) {
            while (i != 0) {
                storage[i] = storage[i - 1];
                i = i - 1;
            }
            storage[0] = r;
        }
        size = size();
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (!storage[i].toString().equals(uuid) & i < 10000) {
            i = i + 1;
        }
        for (int j = i; j < size; j++) {
            storage[j] = storage[j + 1];
        }
        size = size();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int j = 0; j < size(); j++) {
            resumes[j] = storage[j];
        }
        return resumes;
    }

    int size() {
        int i = 0;
        while (storage[i] !=  null){
            i = i + 1;
        }
        return i;
    }
}
