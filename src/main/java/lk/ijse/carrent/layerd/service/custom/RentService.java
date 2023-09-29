package lk.ijse.carrent.layerd.service.custom;

import lk.ijse.carrent.layerd.dto.RentDto;
import lk.ijse.carrent.layerd.service.SuperService;

public interface RentService extends SuperService {

    String addRent(RentDto rentDto) throws Exception;
}
