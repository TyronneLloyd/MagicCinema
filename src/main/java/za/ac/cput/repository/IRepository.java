package za.ac.cput.repository;

import za.ac.cput.entity.Employee;
import java.lang.reflect.Type;
import java.util.List;

public interface IRepository <Type, ID>{
        /**
         * This function gets the given object from the database.
         */
        Type read(ID id);

        /**
         * This function add a new object to the database.
         */
        Type create(Type t);

        /**
         * This function allows the information from the database to be changed.
         */
        Type update(Type t);

        /**
         * This function removes a record from the database.
         */
        boolean delete(ID id);
    }
