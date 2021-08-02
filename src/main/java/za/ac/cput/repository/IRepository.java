package za.ac.cput.repository;

import za.ac.cput.entity.Employee;

import java.util.List;

public interface IRepository <T, id>{

        /**
         * This function gets the given object from the database.
         */
        T get(String id);

        /**
         * This function returns all objects in the table
         */
        List<T> getAll();

        /**
         * This function add a new object to the database.
         */
        void add(T t);

        /**
         * This function allows the information from the database to be changed.
         */
        void update(int id, T t);

        /**
         * This function removes a record from the database.
         */
        void remove(int id);
    }
