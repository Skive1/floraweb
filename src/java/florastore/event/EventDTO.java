
package florastore.event;

import java.io.Serializable;
import java.sql.Timestamp;

public class EventDTO implements Serializable{
    
    private String eventOwner;
    private int eventId;
    private String eventName;
    private String eventLocation;
    private String eventCity;
    private Timestamp startDate;
    private Timestamp endDate;
    private String eventImg;

    public EventDTO() {
    }

    public EventDTO(String eventOwner, int eventId, String eventName, String eventLocation, String eventCity, Timestamp startDate, Timestamp endDate, String eventImg) {
        this.eventOwner = eventOwner;
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventCity = eventCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventImg = eventImg;
    }

    /**
     * @return the eventOwner
     */
    public String getEventOwner() {
        return eventOwner;
    }

    /**
     * @param eventOwner the eventOwner to set
     */
    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
    }

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventLocation
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * @param eventLocation the eventLocation to set
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * @return the eventCity
     */
    public String getEventCity() {
        return eventCity;
    }

    /**
     * @param eventCity the eventCity to set
     */
    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    /**
     * @return the startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the eventImg
     */
    public String getEventImg() {
        return eventImg;
    }

    /**
     * @param eventImg the eventImg to set
     */
    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }
    
    
    
}
