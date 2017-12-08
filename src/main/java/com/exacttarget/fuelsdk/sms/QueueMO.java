/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk.sms;

import com.exacttarget.fuelsdk.ETClient;
import com.exacttarget.fuelsdk.ETResponse;
import com.exacttarget.fuelsdk.ETSdkException;
import java.util.Date;

import com.exacttarget.fuelsdk.MobileConnectObject;
import com.exacttarget.fuelsdk.annotations.ExternalName;
import com.exacttarget.fuelsdk.annotations.RestObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * An <code>QueueMO</code> object represents a helper class which provides interface to queue MO message
 * in the Salesforce Marketing Cloud.
 */
@RestObject(path = "/sms/v1/queueMO",
            primaryKey = "id",
            collection = "items",
            totalCount = "count")
public class QueueMO extends MobileConnectObject{
    
    private String id = null;
    @Expose
    @ExternalName("mobileNumbers")
    private String[] mobileNumbers = null;
    @Expose
    @ExternalName("subscribers")
    private SMSSubscriber[] subscribers = null;
    @Expose
    @ExternalName("shortCode")
    private String shortCode = null;
    @Expose
    @ExternalName("messageText")
    private String messageText = null;
    
    private ETClient client = null;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the mobileNumbers
     */
    public String[] getMobileNumbers() {
        return mobileNumbers;
    }

    /**
     * @param mobileNumbers the mobileNumbers to set
     */
    public void setMobileNumbers(String[] mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    /**
     * @return the subscribers
     */
    public SMSSubscriber[] getSubscribers() {
        return subscribers;
    }

    /**
     * @param subscribers the subscribers to set
     */
    public void setSubscribers(SMSSubscriber[] subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * @return the shortCode
     */
    public String getShortCode() {
        return shortCode;
    }

    /**
     * @param shortCode the shortCode to set
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
    public QueueMO(ETClient client){
        this.client = client;
        setPath("/sms/v1/queueMO");
    }
    
    public ETResponse<QueueMO> QueueMOForSubscribers()
    throws ETSdkException {
        return this.create(client, this);
    }
    
}
