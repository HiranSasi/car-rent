package lk.ijse.carrent.layerd.service.custom.impl;

import lk.ijse.carrent.layerd.dto.CarDetailsDto;
import lk.ijse.carrent.layerd.entity.CarCategoryEntity;
import lk.ijse.carrent.layerd.entity.CarEntity;
import lk.ijse.carrent.layerd.repository.RepoFactory;
import lk.ijse.carrent.layerd.repository.custom.CarCategoryRepo;
import lk.ijse.carrent.layerd.repository.custom.CarDetailsRepo;
import lk.ijse.carrent.layerd.service.custom.CarDetailsSrevice;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsServiceImpl implements CarDetailsSrevice {
CarCategoryRepo carCategoryRepo = (CarCategoryRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CARCATEGORY);
CarDetailsRepo carDetailsRepo = (CarDetailsRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CARDETAILS);
    @Override
    public String addCar(CarDetailsDto carDetailsDto) throws Exception {
         CarCategoryEntity carCategoryEntity = new CarCategoryEntity();
         carCategoryEntity.setName(carDetailsDto.getCarCategoryName());

         carCategoryEntity = carCategoryRepo.get(carCategoryEntity.getName());

       CarEntity carEntity = new CarEntity(carDetailsDto.getId(),carDetailsDto.getBrand(),carDetailsDto.getModel(),carDetailsDto.getYear(),carDetailsDto.getVehicleNumber(),carDetailsDto.getUserName(), carDetailsDto.getPricePerDay(), new CarCategoryEntity(carCategoryEntity.getId(),carCategoryEntity.getName(),carCategoryEntity.getUserName()));
        Integer id = carDetailsRepo.add(carEntity);

        if(id != -1){
            return " Success Added";
        }else {
            return "Fail Added";
        }
    }

    @Override
    public List<CarDetailsDto> getAll() throws Exception {
       List<CarEntity> carEntities = carDetailsRepo.getAll();
       List<CarDetailsDto> carDetailsDtos = new ArrayList<>();

        for (CarEntity entity:carEntities
             ) {
            carDetailsDtos.add(new CarDetailsDto(entity.getId(), entity.getCarCategoryEntity().getId(), entity.getUserName(), entity.getBrand(), entity.getModel(), entity.getYear(), entity.getVehicleNumber(), entity.getPricePerDay(), entity.getCarCategoryEntity().getName()));

        }
        return carDetailsDtos;
    }

    @Override
    public CarDetailsDto search(String id) throws Exception {
        CarEntity entity = carDetailsRepo.get(id);

        CarDetailsDto carDetailsDto = new CarDetailsDto(entity.getId(), entity.getCarCategoryEntity().getId(), entity.getUserName(), entity.getBrand(), entity.getModel(), entity.getYear(), entity.getVehicleNumber(), entity.getPricePerDay(), entity.getCarCategoryEntity().getName());

     return carDetailsDto;
    }

    @Override
    public String update(CarDetailsDto carDetailsDto) throws Exception {
        CarCategoryEntity carCategoryEntity = new CarCategoryEntity();
        carCategoryEntity.setName(carDetailsDto.getCarCategoryName());

        carCategoryEntity = carCategoryRepo.get(carCategoryEntity.getName());

        CarEntity carEntity = new CarEntity(carDetailsDto.getId(),carDetailsDto.getBrand(),carDetailsDto.getModel(),carDetailsDto.getYear(),carDetailsDto.getVehicleNumber(),carDetailsDto.getUserName(), carDetailsDto.getPricePerDay(), new CarCategoryEntity(carCategoryEntity.getId(),carCategoryEntity.getName(),carCategoryEntity.getUserName()));
        Integer id = carDetailsRepo.update(carEntity);

        if(id != -1){
            return " Update Success";
        }else {
            return "Fail Update";
        }
    }

    @Override
    public String delete(String id) throws Exception {


        Integer ids = carDetailsRepo.delete(id);

        if (ids != -1){

            return "Delete Success";
        }else {
            return "Delete Fail";
        }
    }
}

