package lk.ijse.carrent.layerd.service.custom.impl;

import lk.ijse.carrent.layerd.dto.CustomerDto;
import lk.ijse.carrent.layerd.entity.CustomerEntity;
import lk.ijse.carrent.layerd.repository.RepoFactory;
import lk.ijse.carrent.layerd.repository.custom.CustomerRepo;
import lk.ijse.carrent.layerd.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.List;


public class CustomerServiceImpl implements CustomerService {

    CustomerRepo customerRepo = (CustomerRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto customerDto) throws Exception {

        CustomerEntity customerEntity = new CustomerEntity(customerDto.getId(),customerDto.getNic(),customerDto.getName(),customerDto.getAddress(),customerDto.getDob(),customerDto.getUserName(),customerDto.getMobil());

        Integer id = customerRepo.add(customerEntity);


        if (id != -1) {

            return "Successfully Added";
        } else {
            return "Fail Added";
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() throws Exception {
        List<CustomerEntity> customerEntities = customerRepo.getAll();
        List<CustomerDto>customerDtos = new ArrayList<>();

        for (CustomerEntity entity:customerEntities
             ) {
            customerDtos.add(new CustomerDto(entity.getId(),entity.getNic(),entity.getName(),entity.getAddress(),entity.getDob(), entity.getUserName(),entity.getMobil()));
        }
        return customerDtos;
    }
}
