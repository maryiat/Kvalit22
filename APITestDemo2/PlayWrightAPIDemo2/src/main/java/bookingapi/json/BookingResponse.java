package bookingapi.json;

public class BookingResponse {
	
	public int bookingid;
	public BookingDetails booking;
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public BookingDetails getBooking() {
		return booking;
	}
	public void setBooking(BookingDetails booking) {
		this.booking = booking;
	}
}

