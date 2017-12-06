/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk.MobilePush;

/**
 *
 * Represents a center point of the location circle
 */
public class LocationCenter {
    public double latitude;
    public double longitude;
    
    public LocationCenter(double lat, double lon)
    {
        latitude = lat;
        longitude = lon;
    }
}
