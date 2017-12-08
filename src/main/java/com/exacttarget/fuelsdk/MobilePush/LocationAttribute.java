/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk.mobilepush;

/**
 * Represents attributes for the location
 */
public class LocationAttribute {
    public String attribute;
    public String value;
    
    public LocationAttribute(String attr, String val)
    {
        attribute = attr;
        value = val;
    }
}
