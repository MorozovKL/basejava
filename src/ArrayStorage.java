/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null & i < 10000) {
            storage[i] = null;
            i = i + 1;
        }
    }

    void save(Resume r) {
        int i = size();
        if (i != 10000) {
            while (i != 0) {
                storage[i] = storage[i - 1];
                i = i - 1;
            }
            storage[0] = r;
        }
    }

    Resume get(String uuid) {

        Resume[] nStorage = getAll();
        int n = 0;
        for (int i = 0; i < nStorage.length; i++){
            if (nStorage[i].toString().equals(uuid)){
                n = i;
                break;
            }
        }
        if (n != 0){
            return nStorage[n];
        }
        else {
            return new Resume();
        }
    }

    void delete(String uuid) {
        int i = 0;
        while (!storage[i].toString().equals(uuid) & i < 10000) {
            i = i + 1;
        }
        while (storage[i] != null) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int i = size();
        Resume[] nStorage = new Resume[i];
        for (int j = 0; j < i; j++) {
            nStorage[j] = storage[j];
        }
        return nStorage;
    }

    int size() {
        int i = 0;
        while (storage[i] != null & i < 10000) {
            i = i + 1;
        }
        return i;
    }
}
