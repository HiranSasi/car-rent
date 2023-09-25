package lk.ijse.carrent.layerd.service;

import lk.ijse.carrent.layerd.service.custom.impl.CarCategoryServiceImpl;
import lk.ijse.carrent.layerd.service.custom.impl.CarDetailsServiceImpl;
import lk.ijse.carrent.layerd.service.custom.impl.CustomerServiceImpl;
import lk.ijse.carrent.layerd.service.custom.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){

        if(serviceFactory == null){

            serviceFactory = new ServiceFactory();

        }

        return serviceFactory;


    }

    public SuperService getService(ServiceType type){

        switch(type){

            case USER:
                return new UserServiceImpl();
            case CARCATEGORY:
                return new CarCategoryServiceImpl();
            case CARDETAILS:
                return new CarDetailsServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();




            default:
                return null;
        }


    }

    public enum ServiceType{

       USER,CARCATEGORY,CARDETAILS,CUSTOMER

    }

}
