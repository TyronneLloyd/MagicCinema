package za.ac.cput.services;
/*
    @Description:Repository ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 03 August 2021
*/
public interface IService <Type, ID>{
    Type create(Type t);
    Type read(ID id);
    Type update(Type t);
    boolean delete(ID id);
}
