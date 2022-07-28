package com.personsApi.personApi.utils;



import com.personsApi.personApi.entity.Person;
import com.personsApi.personApi.entity.ResourceType;

import java.io.IOException;

public class UtilsTypeResource {
    public static String getResource(Person user, String resourceType){
        try {
            if(user == null){
                return "user does not exist";
            }
            return user.getResource().get(ResourceType.valueOf(resourceType)).toString();
        } catch (IllegalArgumentException e) {
            return  "invalid type Resource";
        }
    }

    public static String setResource(Person user, String resourceType, double resource){
        try {
            if(user == null){
                return "user does not exist";
            }
            user.getResource().put(ResourceType.valueOf(resourceType), resource);
        } catch (IllegalArgumentException e) {
            return "invalid type Resource";
        }
        return "resurce changed";
    }







}
