/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.exacttarget.fuelsdk.mobilepush.LocationAttribute;
import com.exacttarget.fuelsdk.mobilepush.LocationCenter;
import com.exacttarget.fuelsdk.mobilepush.MobilePushLocation;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MobilePushLocationTest {
    private static ETClient client = null;
    private static String locId = "";
    
    public MobilePushLocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws ETSdkException {
        client = new ETClient("fuelsdk.properties");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void _01_createLocationTest() throws ETSdkException
    {
        MobilePushLocation loc = new MobilePushLocation();
        loc.setName("Location SF Tower");
        loc.setLocation("SF Tower Location on Ohio Street");
        loc.setDescription("111 Monument Cir #222, Indianapolis, IN 46204");
        loc.setRadius(10);
        loc.setCenter(new LocationCenter(39.769624, -86.157063));
        loc.setAttributes( new LocationAttribute[] 
                {
                    new LocationAttribute("Address 1", "111 Monument Cir") 
                }
        );
        
        ETResponse<MobilePushLocation> response = client.create(loc);
        System.out.println("resp="+ response.toString());
        //assertEquals(response.getStatus(), "OK");
        //assertEquals(response.getResponseMessage(), "Created");
        //assertNotNull(response.getRequestId());
        
        ETResult<MobilePushLocation> result = response.getResult();
        System.out.println("res="+ result.toString());        
        assertEquals(result.getResponseCode(), "201");
        assertEquals(result.getResponseMessage(), "Created");
        System.out.println("loc = "+result.getObject());
        locId = result.getObject().getId();
        System.out.println("loc = "+locId);
    }
    
    @Test
    public void _02_getAllLocations() throws ETSdkException
    {
        System.out.println("locid="+locId);
        ETResponse<MobilePushLocation> response = client.retrieve(MobilePushLocation.class);
        System.out.println("resp="+ response.toString());
        assertEquals(response.getResponseCode(), "200");
        assertEquals(response.getResponseMessage(), "OK");
        assertNotNull(response.getRequestId());         
        
        ETResult<MobilePushLocation> result = response.getResult();
        System.out.println("res="+ result.toString());
//        assertNotNull(result.getObject());
    }      
    
    @Test
    public void _03_getLocation() throws ETSdkException
    {
        System.out.println("locid="+locId);
        ETResponse<MobilePushLocation> response = client.retrieve(MobilePushLocation.class, "id="+locId);
        System.out.println("resp="+ response.toString());
        assertEquals(response.getResponseCode(), "200");
        assertEquals(response.getResponseMessage(), "OK");
        assertNotNull(response.getRequestId());         
//        
        ETResult<MobilePushLocation> result = response.getResult();
        System.out.println("res="+ result.toString());
        assertNotNull(result.getObject());
    }      
    
    @Test
    public void _04_updateLocation() throws ETSdkException
    {
        System.out.println("locid="+locId);
        MobilePushLocation mpl = new MobilePushLocation();
        mpl.setId(locId);
        mpl.setDescription("Updated description");
        mpl.setName("Test Location");
        mpl.setCenter(new LocationCenter(39.769624, -86.157063));
        
        ETResponse<MobilePushLocation> response = client.update(mpl);
        System.out.println("resp="+ response.toString());
        //assertEquals(response.getResponseCode(), "200");
        //assertEquals(response.getStatus(), "OK");
        assertNotNull(response);         

        ETResult<MobilePushLocation> result = response.getResult();
        System.out.println("res="+ result.toString());
        assertEquals(result.getResponseCode(), "200");
    }     
    
    @Test
    public void _05_deleteLocation() throws ETSdkException
    {
        System.out.println("locid="+locId);
        MobilePushLocation mpl = new MobilePushLocation();
        mpl.setId(locId);
        
        ETResponse<MobilePushLocation> response = client.delete(mpl);
        System.out.println("resp="+ response.toString());
        assertNotNull(response);         

        ETResult<MobilePushLocation> result = response.getResult();
        System.out.println("res="+ result.toString());            
        assertEquals(result.getResponseCode(), "200");
        assertEquals(result.getStatus(), ETResult.Status.OK);        
    }    
    
}
