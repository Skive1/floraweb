
package florastore.manageEvent2;

public class TotalPriceDTO {
    private int eventId;
    private String total;

    public TotalPriceDTO(int eventId, String total) {
        this.eventId = eventId;
        this.total = total;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
