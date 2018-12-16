package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */

public interface Storage {

    void save(Resume r);

    void delete(String uuid);

    void update(Resume r);

    Resume get(String uuid);

    List<Resume> getAllSorted();

    void clear();

    int size();
}
