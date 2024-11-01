package florastore.deliveryOrder2;

import java.sql.Timestamp;

public class DeliverDTO {

    private int eventOrderId;
    private String fullname;
    private String phone;
    private String street;
    private String city;
    private Timestamp orderDate;
    private String paymentOptions;
    private String deliveryOption;
    private Timestamp deliveryDate;
    private String status;
    private int deliveryStaffId;
    private boolean isPaid;
    private String note;
    private double unitPrice;
    private double amount;
    private int quantity;
    private String productName;
    private String productType;
    private String productCondition;

    public DeliverDTO(int eventOrderId, String fullname, String phone, String street, String city, Timestamp orderDate, String paymentOptions, Timestamp deliveryDate, String status, int deliveryStaffId, boolean isPaid, String note, double unitPrice, double amount, int quantity, String productName, String productType, String productCondition) {
        this.eventOrderId = eventOrderId;
        this.fullname = fullname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.orderDate = orderDate;
        this.paymentOptions = paymentOptions;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.deliveryStaffId = deliveryStaffId;
        this.isPaid = isPaid;
        this.note = note;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.quantity = quantity;
        this.productName = productName;
        this.productType = productType;
        this.productCondition = productCondition;
    }


    
    public DeliverDTO(int eventOrderId, String fullname, String phone, String street, String city, Timestamp deliveryDate, String status, int deliveryStaffId, double amount, boolean isPaid, String note, String deliveryOption) {
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
        this.deliveryOption = deliveryOption;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getDeliveryStaffId() {
        return deliveryStaffId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(String paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
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

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
