package lk.carrental.carrental.service;

import lk.carrental.carrental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    String generateCustomerIds();
    int wholeRegisteredCustomerCount();
    int dailyRegisteredCustomerCount(String customerRegisteredDate);
}
