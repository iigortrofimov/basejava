package basejava.project.webapp.storage;

import basejava.project.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListStorageTest extends AbstractStorageTest{

    public ListStorageTest() {
        super(new ListStorage());
    }
}