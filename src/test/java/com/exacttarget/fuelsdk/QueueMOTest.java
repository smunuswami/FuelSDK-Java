/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk;

import com.exacttarget.fuelsdk.sms.QueueMO;
import com.exacttarget.fuelsdk.sms.SMSSubscriber;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueMOTest {
    private static ETClient client = null;
    private static String unique = "";
    
    public QueueMOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws ETSdkException {
        client = new ETClient("fuelsdk.properties");
        unique = UUID.randomUUID().toString();
    }
    
    @Test
    public void queueMOMessage() throws ETSdkException
    {
        QueueMO q = new QueueMO(client);
        SMSSubscriber[] subscribers = new SMSSubscriber[2];
        SMSSubscriber sub1 = new SMSSubscriber();
        sub1.setMobileNumber("12055550100");
        sub1.setSubscriberKey("12055550100");
        SMSSubscriber sub2 = new SMSSubscriber();
        sub2.setMobileNumber("12051550100");
        sub2.setSubscriberKey("12051550100");
        subscribers[0] = sub1;
        subscribers[1] = sub2;
        q.setSubscribers(subscribers);
        q.setShortCode("10766790");
        
        ETResponse<QueueMO> response = q.QueueMOForSubscribers();
        
        System.out.println("resp="+ response.toString());
        assertEquals(response.getResponseCode(), "200");
        assertEquals(response.getResponseMessage(), "OK");
        assertNotNull(response.getRequestId());         
        
        ETResult<QueueMO> result = response.getResult();
        System.out.println("res="+ result.toString());
        
        assertNotNull(result.getObject());
        
    } 
}
