package za.ac.cput.Util;
/*
    @Description:Employees Entity ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 4 June 2021
 */
import java.util.UUID;

public class GenericHelper {
    public static String generateId(){

        return UUID.randomUUID().toString();
    }
}
