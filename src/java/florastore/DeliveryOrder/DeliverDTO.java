package florastore.DeliveryOrder;

import java.sql.Timestamp;

public class DeliverDTO {

    private int eventOrderId;
    private String fullname;
    private String phone;
    private String street;
    private String city;
    private Timestamp deliveryDate;
    private String status;
    private int deliveryStaffId;
    private double amount;
    private boolean isPaid;
    private String note;

    public DeliverDTO(int eventOrderId, String fullname, String phone, String street, String city, Timestamp deliveryDate, String status, int deliveryStaffId, double amount, boolean isPaid, String note) {
        this.eventOrderId = eventOrderId;
        this.fullname = fullname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.deliveryStaffId = deliveryStaffId;
        this.amount = amount;
        this.isPaid = isPaid;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public int getDeliveryStaffId() {
        return deliveryStaffId;
    }

    public void setDeliveryStaffId(int deliveryStaffId) {
        this.deliveryStaffId = deliveryStaffId;
    }

    public int getEventOrderId() {
        return eventOrderId;
    }

    public void setEventOrderId(int eventOrderId) {
        this.eventOrderId = eventOrderId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
