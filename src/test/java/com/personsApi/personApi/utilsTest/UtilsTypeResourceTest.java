package com.personsApi.personApi.utilsTest;


import com.personsApi.personApi.entity.Person;
import com.personsApi.personApi.entity.ResourceType;
import com.personsApi.personApi.repository.PersonRepository;
import com.personsApi.personApi.utils.UtilsTypeResource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class UtilsTypeResourceTest {
    @Autowired
    PersonRepository personRepository;
    private Person us = new Person();
    private double delta = 0.00000001;

    @Before
    public void beforeCustomer(){
        Map<ResourceType, Double> resources = new HashMap<>();
        resources.put(ResourceType.GAS, 1000.0);
        resources.put(ResourceType.HOT_WATER, 1000.0);
        resources.put(ResourceType.COLD_WATER, 1000.0);
        us.setResource(resources);
    }

    @After
    public void customer(){
        Map<ResourceType, Double> resources = new HashMap<>();
        resources.put(ResourceType.GAS, 1000.0);
        resources.put(ResourceType.HOT_WATER, 1000.0);
        resources.put(ResourceType.COLD_WATER, 1000.0);
        us.setResource(resources);
    }

    @Test
    public void setGas(){
        double add = 100.0;
        double expected =  add;
        UtilsTypeResource.setResource(us, "GAS", add);
        Assert.assertEquals(expected, us.getResource().get(ResourceType.GAS), delta);
    }

    @Test
    public void setHotWater(){
        double add = 100.0;
        double expected =  add;
        UtilsTypeResource.setResource(us, "HOT_WATER", add);
        Assert.assertEquals(expected, us.getResource().get(ResourceType.HOT_WATER), delta);
    }

    @Test
    public void setColdWate(){
        double add = 100.0;
        double expected =  add;
        UtilsTypeResource.setResource(us, "COLD_WATER", add);
        Assert.assertEquals(expected, us.getResource().get(ResourceType.COLD_WATER), delta);
    }

    @Test
    public void invalidSet(){
        String result = UtilsTypeResource.setResource(us, "OIL", 100);
        Assert.assertEquals("invalid type Resource", result);
    }

    @Test
    public void invaliGet(){
        String result = UtilsTypeResource.getResource(us, "OIL");
        Assert.assertEquals("invalid type Resource", result);
    }

    @Test
    public void nullPersonGet(){
        Person user = null;
        String result = UtilsTypeResource.getResource(user, "GAS");
        Assert.assertEquals("user does not exist",  result);
    }
    @Test
    public void nullPersonSet(){
        Person user = null;
        String result = UtilsTypeResource.setResource(user, "GAS", 100.0);
        Assert.assertEquals("user does not exist",  result);
    }

}
