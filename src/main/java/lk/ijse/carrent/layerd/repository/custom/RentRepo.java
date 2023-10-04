package lk.ijse.carrent.layerd.repository.custom;

import lk.ijse.carrent.layerd.entity.RentEntity;
import lk.ijse.carrent.layerd.repository.CrudRepo;

import java.util.Date;

public interface RentRepo extends CrudRepo<RentEntity,String> {

    Integer updateReturnDate(RentEntity rent) throws Exception;
    Date carReturnDate(String id) throws Exception;

    Date carReturnNull(String id) throws Exception;

    String carRentId(String id) throws Exception;
    String custRentId(String id) throws Exception;

    Date custReturnNull(String id) throws Exception;

    Date custReturnDate(String id) throws Exception;
}
