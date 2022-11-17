package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.CustomerDTO;
import lk.carrental.carrental.service.CustomerService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"customerId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String customerId){
        return new ResponseUtil(200,"Ok",customerService.searchCustomer(customerId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"All the customers are loaded",customerService.getAllCustomers());
    }

    @GetMapping(params = {"customerId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerIds(@RequestParam String customerId){
        return new ResponseUtil(200,"Ok",customerService.generateCustomerIds());
    }

    @GetMapping(path = "/Count/{wholeCustomerCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil wholeRegisteredCustomerCount(@PathVariable String wholeCustomerCount){
        return new ResponseUtil(200,"Ok",customerService.wholeRegisteredCustomerCount());
    }

    @GetMapping(path = "/Count/{dailyCustomerCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil dailyRegisteredCustomerCount(@PathVariable String dailyCustomerCount){
        return new ResponseUtil(200,"Ok",customerService.dailyRegisteredCustomerCount(dailyCustomerCount));
    }
}
