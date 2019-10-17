package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Customer;
import nararii.tkachuk.com.mappers.CustomerMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;

import java.util.List;

public final class CustomerService {
    private CustomerService() {
        throw new UnsupportedOperationException();
    }

    public static Customer getCustomerById(String filePath, int ID) {
        List<Customer> customerList = FileReaderUtil.readObjects(filePath, new CustomerMapper());
        Customer correctOne = null;
        for (Customer customer : customerList) {
            if (customer.getId() == ID) {
                correctOne = customer;
            }
        }
        return correctOne;
    }

    public static Customer getCustomerByPhoneNumber(String filePath, String PhoneNumber) {
        List<Customer> customerList = FileReaderUtil.readObjects(filePath, new CustomerMapper());
        Customer correctOne = null;
        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(PhoneNumber)) {
                correctOne = customer;
            }
        }
        return correctOne;
    }

    public static Customer createNewCustomer(String filePath, String firstName, String lastName, String phoneNumber){
        EntityIDService.createFileWithMaxID(filePath, new CustomerMapper());

        Integer id = EntityIDService.generateID(EntityIDService.getIDFilePath(filePath));

        return new Customer(firstName,lastName,id,phoneNumber);
    }
}
