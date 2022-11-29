package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.custom.TodoDAO;
import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.util.ConnectionUtil;

import java.sql.Connection;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(Connection connection, DAOTypes daoType){
        switch (daoType){
            case USER:
                return (T) new UserDAOImpl(connection);
            case TODO_ITEM:
                return (T) new TodoDAO()
        }

    }
}
