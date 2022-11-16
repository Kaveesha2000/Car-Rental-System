package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.CustomerDTO;
import lk.carrental.carrental.entity.Customer;
import lk.carrental.carrental.repo.CustomerRepo;
import lk.carrental.carrental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCustomerId())) {
            repo.save(mapper.map(dto, Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("There is no such customer. Try again...!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getCustomerId())){
            repo.save(mapper.map(dto,Customer.class));
        }else {
            throw new RuntimeException("No such customer. Try again...!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(),CustomerDTO.class);
        }else {
            throw new RuntimeException("No customer for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public String generateCustomerIds() {
        return repo.generateCustomerId();
    }

    @Override
    public int wholeRegisteredCustomerCount() {
        return repo.registeredCustomerCount();
    }

    @Override
    public int dailyRegisteredCustomerCount(String customerRegisteredDate) {
        return repo.dailyRegisteredCustomerCount(customerRegisteredDate);
    }
}
