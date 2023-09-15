package lk.ijse.carrent.layerd.service.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.carrent.layerd.dto.UserDto;
import lk.ijse.carrent.layerd.entity.UserEntity;
import lk.ijse.carrent.layerd.repository.RepoFactory;
import lk.ijse.carrent.layerd.repository.custom.UserRepo;
import lk.ijse.carrent.layerd.service.custom.UserService;

public class UserServiceImpl implements UserService {

    UserRepo userRepo = (UserRepo) RepoFactory.getInstance().getRepo(RepoFactory.RepoType.USER);

    @Override
    public String addUser(UserDto userDto) throws Exception{
        UserEntity userEntity = new UserEntity(userDto.getId(),
                userDto.getUserName(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword());

        Integer id = userRepo.add(userEntity);
         if (id != -1){

             return "Success Added";

         }else {
             return "Fail Added";
         }
    }
}
