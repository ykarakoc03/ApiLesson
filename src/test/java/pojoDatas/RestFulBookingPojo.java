package pojoDatas;

public class RestFulBookingPojo {

    /*
        {
            "firstname" : "Drake",
                "lastname" : "F..",
                "totalprice" : 4000,
                "depositpaid" : true,
                "bookingdates" : {
            "checkin" : "2022-01-01",
                    "checkout" : "2023-01-01"
        },
     */
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesPojoPost bookingdates;
    private String additionalneeds;

    public RestFulBookingPojo() {
    }

    public RestFulBookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesPojoPost bookingdates,String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }


    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojoPost getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojoPost bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "RestFulBookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
