package lk.ijse.carrent.layerd.repository;

import lk.ijse.carrent.layerd.repository.custom.impl.CarCategoryRepoImpl;
import lk.ijse.carrent.layerd.repository.custom.impl.CarDetailsRepoImpl;
import lk.ijse.carrent.layerd.repository.custom.impl.CustomerRepoImpl;
import lk.ijse.carrent.layerd.repository.custom.impl.UserRepoImpl;

public class RepoFactory {
    private static RepoFactory repoFactory;
    private RepoFactory(){}

    public static RepoFactory getInstance(){

        return (repoFactory == null)? repoFactory = new RepoFactory():repoFactory;
    }

    public SuperRepo getRepo(RepoType type){
        switch (type){

            case USER:
                return new UserRepoImpl();
            case CARCATEGORY:
                return new CarCategoryRepoImpl();
            case CARDETAILS:
                return new CarDetailsRepoImpl();
            case CUSTOMER:
                return new CustomerRepoImpl();

            default :
                return null;
        }
    }

    public enum RepoType{
        USER,CARCATEGORY,CARDETAILS,CUSTOMER
    }


}
