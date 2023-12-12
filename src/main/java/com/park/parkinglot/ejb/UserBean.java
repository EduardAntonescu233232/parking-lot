package com.park.parkinglot.ejb;

import com.park.parkinglot.common.CarDto;
import com.park.parkinglot.entities.Car;
import com.park.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class UserBean {
    public List<CarDto> findAllCars() {
        LOG.info("findAllUsers");
        try {
            TypedQuery<Car> typedQuery =
                    entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
