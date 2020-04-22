package com.api.test;

import com.api.apiFactory.ApiEndPoints;
import com.api.apiFactory.ApiHeaders;
import com.api.pojo.Booking;
import com.api.utils.ExtentReportLogger;
import com.api.utils.ExtentReportManager1;
import com.api.utils.Helper;
import com.api.utils.SerializeDeserialize;
import com.aventstack.extentreports.Status;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestApiTest extends BaseTest {

    RequestSpecification httpRequest = getRequestSpec();

    @Test(enabled=true,description = "Verify whether /booking end point is able to bring booking details of all the user")
    public void getAllBookings() {
        httpRequest.headers(ApiHeaders.defaultHeader());
        Response rs=httpRequest.request(Method.GET, ApiEndPoints.GET_BOOKING);
        ExtentReportManager1.getTest().log(Status.INFO,"Status Code : "+rs.getStatusCode());
        ExtentReportManager1.getTest().log(Status.INFO,"Response    : "+rs.getBody().prettyPrint().toString());
        Assert.assertTrue(rs.getBody().jsonPath().getList("bookings.bookingid").size() > 0);
    }

    @Test(enabled=true,description = "Verify whether /booking end point is able to bring booking details of single user")
    public void getSingleBooking() {
        httpRequest.headers(ApiHeaders.defaultHeader());
        httpRequest.queryParam("1");
        Response rs= httpRequest.request(Method.GET, ApiEndPoints.GET_BOOKING);
        ExtentReportManager1.getTest().log(Status.INFO,"Status Code : "+rs.getStatusCode());
        ExtentReportManager1.getTest().log(Status.INFO,"Response    : "+rs.getBody().prettyPrint().toString());
        Assert.assertEquals(rs.getBody().jsonPath().getString("bookings[0].bookingid"), "1");
    }

    @Test(enabled=true,description = "Verify whether /booking end point is able to create new booking details of single user")
    public void createBooking() {
        int roomID=Helper.generateRandomRoomNumber();
        Booking bookingDetails = new Booking(1,true,"mnmoup@gmail.com","testFirstName","testLasttName","99999999999",roomID,"2019-01-01","2019-01-07");
        httpRequest.headers(ApiHeaders.headerWithContentType());
        httpRequest.body(SerializeDeserialize.getJson(bookingDetails));
        ExtentReportManager1.getTest().log(Status.INFO,"Request    : "+SerializeDeserialize.getJson(bookingDetails).toString());
        Response rs=httpRequest.request(Method.POST, ApiEndPoints.GET_BOOKING);
        ExtentReportManager1.getTest().log(Status.INFO,"Status Code : "+rs.getStatusCode());
        Assert.assertEquals(rs.getStatusCode(), 201);
        ExtentReportManager1.getTest().log(Status.INFO,"Response    : "+rs.getBody().prettyPrint().toString());
        ExtentReportManager1.getTest().log(Status.PASS,"Booking created Successfully");

        ExtentReportManager1.getTest().log(Status.INFO,"Verifying created booking");
        String createdBookingID= rs.getBody().jsonPath().getString("bookingid");
        Response subsiquentRequestResponse=httpRequest.queryParam("roomid",roomID).request(Method.GET,ApiEndPoints.GET_BOOKING);
        ExtentReportManager1.getTest().log(Status.INFO,"Response    : "+subsiquentRequestResponse.getBody().asString());
        Assert.assertEquals(subsiquentRequestResponse.getBody().jsonPath().getString("bookings[0].firstname"),"testFirstName");
    }
    @Test(enabled=true,description = "Verify whether /booking end point is able to bring booking details of single user")
    public void validateSchemaForSingleUserDetials() {
        int roomID=Helper.generateRandomRoomNumber();
        Booking bookingDetails = new Booking(1,true,"mnmoup@gmail.com","testFirstName","testLasttName","99999999999",roomID,"2019-01-01","2019-01-07");
        httpRequest.headers(ApiHeaders.headerWithContentType());
        httpRequest.body(SerializeDeserialize.getJson(bookingDetails));
        ExtentReportManager1.getTest().log(Status.INFO,"Request    : "+SerializeDeserialize.getJson(bookingDetails).toString());
        Response rs=httpRequest.request(Method.POST, ApiEndPoints.GET_BOOKING);
        ExtentReportManager1.getTest().log(Status.INFO,"Status Code : "+rs.getStatusCode());
        Assert.assertEquals(rs.getStatusCode(), 201);
        ExtentReportManager1.getTest().log(Status.INFO,"Response    : "+rs.getBody().prettyPrint().toString());
        ExtentReportManager1.getTest().log(Status.PASS,"Booking created Successfully");
        ExtentReportManager1.getTest().log(Status.INFO,"Verifying Json Response Schema");
        rs.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaFile.json")).log().all();

    }
}
