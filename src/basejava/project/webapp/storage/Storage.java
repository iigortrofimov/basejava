package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */

public interface Storage {

    void update(Resume r);

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAll();

    int size();
}
