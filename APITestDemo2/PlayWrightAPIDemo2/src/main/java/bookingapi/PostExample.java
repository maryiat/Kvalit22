package bookingapi;

import testbase.BaseClassPw;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.RequestOptions;

import bookingapi.json.BookingDates;
import bookingapi.json.BookingDetails;
import bookingapi.json.BookingResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PostExample extends BaseClassPw {

	@Test
	public void createHotelBooking() {

		// Create Json object representing booking POST request body
		BookingDates dates = new BookingDates("2018-01-01", "2019-01-01");
		BookingDetails details = new BookingDetails("Maria", "last", 123, true, dates, "Breakfast");

		// Send a Post request to hotel service and use Json object as a body
		// setData() method automatically serializes Java object, i.e. converts it to
		// Json string
		RequestOptions body = RequestOptions.create().setData(details);
		String endpointUrl = "https://restful-booker.herokuapp.com/booking";
		
		APIResponse apiResponse = context.request().post(endpointUrl, body);
		
		System.out.println(apiResponse.text());

		// Verify that post request succeeded
		PlaywrightAssertions.assertThat(apiResponse).isOK();
		Assertions.assertEquals(apiResponse.status(), 200);

		// Create Json serializer object

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		// Deserialize JSON string to Java object
		BookingResponse bookingResponse = gson.fromJson(apiResponse.text(), BookingResponse.class);

		// Verify that test data in response is correct
		Assertions.assertEquals(bookingResponse.getBooking().getFirstname(), "Maria");

	}

}
