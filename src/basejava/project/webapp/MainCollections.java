package basejava.project.webapp;

import basejava.project.webapp.model.Resume;
import basejava.project.webapp.storage.ListStorage;
import basejava.project.webapp.storage.Storage;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
//
    public static void main(String[] args) {
        Storage storage = new ListStorage();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
        storage.save(RESUME_4);
        System.out.println(Arrays.toString(storage.getAll()));
        storage.delete(UUID_3);
        System.out.println(Arrays.toString(storage.getAll()));
        System.out.println(storage.get(UUID_2));
        System.out.println(storage.size());
       // storage.save(RESUME_4);
       // storage.delete("DUMMY");
        //storage.update(new Resume());



//        Collection<Resume> collection = new ArrayList<>();
//        collection.add(RESUME_1);
//        collection.add(RESUME_2);
//        collection.add(RESUME_3);
//        collection.add(RESUME_4);
//
//        for (Resume r : collection) {
//            System.out.print(r + " ");
//            if (Objects.equals(r.getUuid(), UUID_1)) {
////          collection.remove(r);
//            }
//        }
//
//        Iterator<Resume> iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            Resume r = iterator.next();
//            System.out.println(r);
//            if (Objects.equals(r.getUuid(), UUID_1)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(collection.toString());
//
//        Map<String, Resume> map = new HashMap<>();
//        map.put(UUID_1, RESUME_1);
//        map.put(UUID_2, RESUME_2);
//        map.put(UUID_3, RESUME_3);
//
//        for (Map.Entry<String, Resume> entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }

    }
}