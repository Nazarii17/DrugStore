package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.EntityID;
import nararii.tkachuk.com.mappers.CSVMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;
import nararii.tkachuk.com.utils.FileWriterUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EntityIDService {
    private EntityIDService() {
        throw new UnsupportedOperationException();
    }



    public static String findMaxID(List<EntityID> list) {
        ArrayList<Integer> IDList = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();
        for (EntityID id : list) {
//            stringBuffer.append(id.getId() + "\n");
            IDList.add(id.getId());
        }

        return Collections.max(IDList).toString() + "\n";
//        return stringBuffer.toString();
    }


    public static Integer getMaxIDFromExistedFile(String filePath){
        String string = FileReaderUtil.readStringFromFile(filePath);
        int id = Integer.parseInt(string.trim());
        System.out.println(id);
        return id;
    }

    public static void writeIDtoFile(String filePath, List<? extends EntityID> list) {
        findMaxID((List<EntityID>) list);
        FileWriterUtil.overwriteTextToFile(filePath, findMaxID((List<EntityID>) list));
    }

    public static void overwriteIDinFile(String filePath, String id) {

        FileWriterUtil.overwriteTextToFile(filePath, id);
    }

    public static Integer generateID(String filePath) {
//         id = Integer.parseInt(FileReaderUtil.readStringFromFile(filePath).trim());
         int id = getMaxIDFromExistedFile(filePath);

        return id + 1;
    }

    public static String getIDFilePath(String filePath){
        char[] chars = filePath.toCharArray();
        StringBuffer fileIDPath = new StringBuffer(filePath);
        return fileIDPath.insert(chars.length -4,"ID").toString();
    }

    public static <T extends EntityID> void createFileWithMaxID(String filePath, CSVMapper<T> csvMapper) {

        List<T> list = FileReaderUtil.readObjects(filePath, csvMapper);

        writeIDtoFile(getIDFilePath(filePath), list);
    }



}



