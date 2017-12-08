/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk;

import com.exacttarget.fuelsdk.sms.QueueMO;
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
        
        ETResponse response = q.QueueMOForSubscribers();
        
        System.out.println("resp="+ response.toString());
        assertEquals(response.getResponseCode(), "200");
        assertEquals(response.getResponseMessage(), "OK");
        assertNotNull(response.getRequestId());         
        
        ETResult<QueueMO> result = response.getResult();
        System.out.println("res="+ result.toString());
        
        assertNotNull(result.getObject());
        
    } 
}
