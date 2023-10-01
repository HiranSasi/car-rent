package lk.ijse.carrent.layerd.service.custom.impl;

import lk.ijse.carrent.layerd.dto.RentDto;
import lk.ijse.carrent.layerd.entity.CarCategoryEntity;
import lk.ijse.carrent.layerd.entity.CarEntity;
import lk.ijse.carrent.layerd.entity.CustomerEntity;
import lk.ijse.carrent.layerd.entity.RentEntity;
import lk.ijse.carrent.layerd.repository.RepoFactory;
import lk.ijse.carrent.layerd.repository.custom.CarCategoryRepo;
import lk.ijse.carrent.layerd.repository.custom.CarDetailsRepo;
import lk.ijse.carrent.layerd.repository.custom.CustomerRepo;
import lk.ijse.carrent.layerd.repository.custom.RentRepo;
import lk.ijse.carrent.layerd.service.custom.RentService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentServiceImpl implements RentService {
    RentRepo rentRepo = (RentRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.RENT);
    CustomerRepo customerRepo = (CustomerRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CUSTOMER);

    CarDetailsRepo carDetailsRepo = (CarDetailsRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CARDETAILS);

    CarCategoryRepo carCategoryRepo = (CarCategoryRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CARCATEGORY);
    @Override
    public String addRent(RentDto rentDto) throws Exception {

        LocalDate from = rentDto.getFromDate();
        LocalDate to = rentDto.getToDate();
        Double perDayRent = rentDto.getPerDayRent();
        Double advance = rentDto.getAdvancedPay();

        Long dayDiff = ChronoUnit.DAYS.between(from,to);



        Integer dayDifferent = Math.toIntExact(dayDiff)+1;

        Double total = perDayRent*dayDifferent;

        if (total >= rentDto.getAdvancedPay()) {

            CustomerEntity customerEntity = customerRepo.get(rentDto.getCustId());
            CarEntity carEntity = carDetailsRepo.get(rentDto.getCarId());
            CarCategoryEntity carCategoryEntity = carCategoryRepo.get(carEntity.getCarCategoryEntity().getName());

            RentEntity rentEntity = new RentEntity(rentDto.getId(), rentDto.getPerDayRent(), Date.valueOf(rentDto.getFromDate()), Date.valueOf(rentDto.getToDate()), rentDto.getAdvancedPay(), rentDto.getRefundableDeposit(), rentDto.getUserName(), new CustomerEntity(customerEntity.getId(), customerEntity.getNic(), customerEntity.getName(), customerEntity.getAddress(), customerEntity.getDob(), customerEntity.getUserName()), new CarEntity(carEntity.getId(), carEntity.getBrand(), carEntity.getModel(), carEntity.getYear(), carEntity.getVehicleNumber(), carEntity.getUserName(), carEntity.getPricePerDay(), new CarCategoryEntity(carCategoryEntity.getId(), carCategoryEntity.getName(), carCategoryEntity.getUserName())));

            Integer id = rentRepo.add(rentEntity);
            if (id != -1) {

                return "Successfully Added";
            } else {
                return "Fail Added";
            }
        }else {
            return "Advance pay is Not Valid";

        }

    }

    @Override
    public RentDto totalAndBalance(RentDto rentDto) throws Exception {
        LocalDate from = rentDto.getFromDate();
        LocalDate to = rentDto.getToDate();
        Double perDayRent = rentDto.getPerDayRent();
        Double advance = rentDto.getAdvancedPay();

        Long dayDiff = ChronoUnit.DAYS.between(from,to);



        Integer dayDifferent = Math.toIntExact(dayDiff)+1;

        Double total = perDayRent*dayDifferent;
        Double balance = total-advance;

        RentDto rentDto1 = new RentDto(total,balance);
        return rentDto1;
    }
}
