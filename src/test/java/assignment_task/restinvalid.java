package assignment_task;

import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import dev.failsafe.internal.util.Assert;

public class restinvalid {
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
    public void createBookingWithoutFirstname() {
        String invalidBookingRequest = "{\n" +
                "    \"lastname\" : \"lastName\",\n" +
                "    \"totalprice\" : 10.11,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"testAdd\"\n" +
                "}";

       // Response response = given()
               // .header("Content-Type", "application/json")
             //   .body(invalidBookingRequest)
               // .post("/booking");

        // التحقق من فشل الطلب
      //  Assert.assertNotEquals(response.getStatusCode(), 200);
}
	private Object header(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}
