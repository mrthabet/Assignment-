package assignment_task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;

public class restassured {

    // URL الأساسي
    String baseUrl = "https://restful-booker.herokuapp.com";

    // بيانات الحجز
    String bookingRequest = "{\n" +
            "    \"firstname\" : \"testFirstName\",\n" +
            "    \"lastname\" : \"lastName\",\n" +
            "    \"totalprice\" : 10.11,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-01-01\",\n" +
            "        \"checkout\" : \"2024-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"testAdd\"\n" +
            "}";

    @Test
    public void createBooking() {
        RestAssured.baseURI = baseUrl;

        // إرسال طلب POST لإنشاء حجز
        Response response = ((Object) given())
                .header("Content-Type", "application/json")
                .body(bookingRequest)
                .post("/booking");

        // التحقق من حالة الاستجابة
        Assert.assertEquals(response.getStatusCode(), 200);

        // التحقق من أن الحجز تم إنشاؤه
       // int bookingId = ((Object) response).jsonPath().getInt("bookingid");
      //  Assert.assertTrue(bookingId > 0, "Booking ID غير صحيح");
    }

	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}
}