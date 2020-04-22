package com.api.test;

import com.api.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

//@Listeners(TestNgListener1.class)
public class BaseTest{


    @BeforeClass
    public RequestSpecification getRequestSpec()
    {
        RestAssured.baseURI = PropertyFileReader.getAllProperties().get("serverUrl");
        System.out.println(PropertyFileReader.getAllProperties().get("serverUrl"));
        return RestAssured.given();
    }

}
