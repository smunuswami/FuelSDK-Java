/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk.MobilePush;

import com.exacttarget.fuelsdk.ETRestObject;
import com.exacttarget.fuelsdk.annotations.ExternalName;
import com.exacttarget.fuelsdk.annotations.RestObject;
import com.google.gson.annotations.Expose;

/**
 * 
 * MobilePushLocation class represents the mobile push location object
 */

@RestObject(path = "/push/v1/location",
            primaryKey = "id",
            collection = "items",
            totalCount = "count")
public class MobilePushLocation extends ETRestObject {
    @Expose
    @ExternalName("id")
    private String id = null;    
    @Expose
    @ExternalName("name")
    private String name = null;
    @Expose
    @ExternalName("location")
    private String location = null;
    @Expose
    @ExternalName("description")
    private String description = null;
    @Expose
    @ExternalName("radius")
    private int radius;
    @Expose
    @ExternalName("locationType")
    private PushMessageLocationType locationType;
    @Expose
    @ExternalName("proximityUuid")
    private String proximityUuid = null;
    @Expose
    @ExternalName("major")
    private int major;
    @Expose
    @ExternalName("minor")
    private int minor;
    
    @Expose
    @ExternalName("center")
    private LocationCenter center;
    
    @Expose
    @ExternalName("attributes")
    private LocationAttribute[] attributes;
    
    
    public MobilePushLocation getSpecificLocation()
    {
        RestObject annotations = this.getClass().getAnnotation(RestObject.class);
        //annotations.
        return null;
    }

    /** 
    * @return The Identifier of the MobilePushLocation object.
    */ 
    @Override
    public String getId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return id;
    }

    /** 
    * @param id     The Identifier of the MobilePushLocation object.
    */    
    @Override
    public void setId(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * @return the locationType
     */
    public PushMessageLocationType getLocationType() {
        return locationType;
    }

    /**
     * @param locationType the locationType to set
     */
    public void setLocationType(PushMessageLocationType locationType) {
        this.locationType = locationType;
    }

    /**
     * @return the proximityUuid
     */
    public String getProximityUuid() {
        return proximityUuid;
    }

    /**
     * @param proximityUuid the proximityUuid to set
     */
    public void setProximityUuid(String proximityUuid) {
        this.proximityUuid = proximityUuid;
    }

    /**
     * @return the major
     */
    public int getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(int major) {
        this.major = major;
    }

    /**
     * @return the minor
     */
    public int getMinor() {
        return minor;
    }

    /**
     * @param minor the minor to set
     */
    public void setMinor(int minor) {
        this.minor = minor;
    }

    /**
     * @return the center
     */
    public LocationCenter getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setCenter(LocationCenter center) {
        this.center = center;
    }

    /**
     * @return the attributes
     */
    public LocationAttribute[] getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(LocationAttribute[] attributes) {
        this.attributes = attributes;
    }
    
    public enum PushMessageLocationType
    {
        GEOFENCE(1),
        BEACON(3);
        private final int value;

        PushMessageLocationType(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }        
    } 


}
