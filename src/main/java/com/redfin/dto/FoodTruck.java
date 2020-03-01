package com.redfin.dto;

/*
FoodTruck DTO objects stores information from FoodTruck service
Storing Limited fields which are required
Addition Fields can be added as per requirement
 */
public class FoodTruck {
    String applicant;
    String block;
    String dayofweekstr;
    int dayorder;
    String end24;
    String endtime;
    String latitude;
    String location;
    String locationdesc;
    String longitude;
    String permit;
    String start24;
    String starttime;


    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }


    public String getDayofweekstr() {
        return dayofweekstr;
    }

    public void setDayofweekstr(String dayofweekstr) {
        this.dayofweekstr = dayofweekstr;
    }


    public String getEnd24() {
        return end24;
    }

    public void setEnd24(String end24) {
        this.end24 = end24;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationdesc() {
        return locationdesc;
    }

    public void setLocationdesc(String locationdesc) {
        this.locationdesc = locationdesc;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getStart24() {
        return start24;
    }

    public void setStart24(String start24) {
        this.start24 = start24;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        return "FoodTruck{" +
                ", applicant='" + applicant + '\'' +
                ", block='" + block + '\'' +
                ", dayofweekstr='" + dayofweekstr + '\'' +
                ", dayorder='" + dayorder + '\'' +
                ", end24='" + end24 + '\'' +
                ", endtime='" + endtime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                ", locationdesc='" + locationdesc + '\'' +
                ", longitude='" + longitude + '\'' +
                ", permit='" + permit + '\'' +
                ", start24='" + start24 + '\'' +
                ", starttime='" + starttime + '\'' +
                '}';
    }

}
