package lk.ijse.dep9.service;

import lk.ijse.dep9.service.custom.impl.*;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        return (serviceFactory == null) ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes serviceType){
        switch (serviceType){
            case USER:
                return (T) new UserServiceImpl();
            case TODO:
                return (T) new TodoServiceImpl();
            default:
                return null;
        }
    }
}
