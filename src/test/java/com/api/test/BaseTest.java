package com.api.test;

import com.api.listener.TestNgListener1;
import com.api.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

@Listeners(TestNgListener1.class)
public class BaseTest extends TestNgListener1 {


    @BeforeClass
    public RequestSpecification getRequestSpec()
    {
        RestAssured.baseURI = PropertyFileReader.getAllProperties().get("serverUrl");
        System.out.println(PropertyFileReader.getAllProperties().get("serverUrl"));
        return RestAssured.given();
    }

}
