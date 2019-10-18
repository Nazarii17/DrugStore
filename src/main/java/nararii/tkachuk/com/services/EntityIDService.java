package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Customer;
import nararii.tkachuk.com.entities.EntityID;
import nararii.tkachuk.com.mappers.CSVMapper;
import nararii.tkachuk.com.mappers.CustomerMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;
import nararii.tkachuk.com.utils.FileWriterUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntityIDService {

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

    public static void writeMaxIDFromListToFile(String filePath, List<? extends EntityID> list) {
        findMaxID((List<EntityID>) list);
        FileWriterUtil.overwriteTextToFile(filePath, findMaxID((List<EntityID>) list));
    }

    public static int generateID(String filePath) {
        int ID = Integer.parseInt(FileReaderUtil.readStringFromFile(filePath).trim());
        return ID + 1;
    }

    public static String getIDFilePath(String filePath) {
        char[] chars = filePath.toCharArray();
        StringBuffer fileIDPath = new StringBuffer(filePath);
        return fileIDPath.insert(chars.length - 4, "ID").toString();
    }

    public static Boolean isPhoneNumberExist(String filePath, String phoneNumber) {
        List<Customer> customerList = FileReaderUtil.readObjects(filePath, new CustomerMapper());

        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends EntityID> void createFileWithMaxID(String filePath, CSVMapper<T> csvMapper) {

        List<T> list = FileReaderUtil.readObjects(filePath, csvMapper);

        writeMaxIDFromListToFile(getIDFilePath(filePath), list);
    }

    public static boolean isPriceNotZero(BigDecimal money) {
        //Validate if money not 0

        if (money.compareTo(BigDecimal.ZERO) == 0) {
            return true;
        } else return false;
//        createFileWithMaxID();
//        money.compareTo(BigDecimal.ZERO) == 0 // true
//        new BigDecimal("0.00").compareTo(BigDecimal.ZERO) == 0 // true

    }


}



