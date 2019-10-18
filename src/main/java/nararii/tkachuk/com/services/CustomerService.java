package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Customer;
import nararii.tkachuk.com.mappers.CustomerMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;
import nararii.tkachuk.com.utils.ValidatorUtil;

import java.util.List;

public class CustomerService {

    public static Customer getCustomerById(String filePath, int id) {
        List<Customer> customerList = FileReaderUtil.readObjects(filePath, new CustomerMapper());
        Customer correctOne = null;
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                correctOne = customer;
            }
        }
        return correctOne;
    }

    public static Customer getCustomerByPhoneNumber(String filePath, String phoneNumber) {
        List<Customer> customerList = FileReaderUtil.readObjects(filePath, new CustomerMapper());
        Customer correctOne = null;
        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                correctOne = customer;
            }
        }
        return correctOne;
    }

    public static Customer createNewCustomer(String filePath, String firstName, String lastName, String phoneNumber) {

        if ((!ValidatorUtil.validatePhoneNumber(phoneNumber) | EntityIDService.isPhoneNumberExist(filePath, phoneNumber))) {
            throw new RuntimeException("Далбайоб, введи нормальний телефон, гавно ти собаче, щоб тебе качка копнула, сука!!!");
        }

        EntityIDService.createFileWithMaxID(filePath, new CustomerMapper());

        return new Customer(firstName, lastName, EntityIDService.generateIDFromFile(EntityIDService.getIDFilePath(filePath)), phoneNumber);
    }
}


