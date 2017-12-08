/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exacttarget.fuelsdk.sms;

import com.exacttarget.fuelsdk.internal.Attribute;

/**
 *
 * @author smunuswami
 */
public class SMSSubscriber {
    private String mobileNumber = null;
    private String subscriberKey = null;
    private Attribute[] Attributes = null;

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the subscriberKey
     */
    public String getSubscriberKey() {
        return subscriberKey;
    }

    /**
     * @param subscriberKey the subscriberKey to set
     */
    public void setSubscriberKey(String subscriberKey) {
        this.subscriberKey = subscriberKey;
    }

    /**
     * @return the Attributes
     */
    public Attribute[] getAttributes() {
        return Attributes;
    }

    /**
     * @param Attributes the Attributes to set
     */
    public void setAttributes(Attribute[] Attributes) {
        this.Attributes = Attributes;
    }
}
