package com.fuck.mobile.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotifications;

import org.json.JSONException;

public class IOSPush {

	public static PushedNotifications  pushIOSMsg(Object deviceToken,String message,int msgCount,Map<String,Object> dict ,Object keystore, String password,boolean production) throws JSONException, CommunicationException, KeystoreException
	{
		msgCount=0;//统一改成0
		  PushNotificationPayload payload =  PushNotificationPayload.complex();
		  payload.addBadge(msgCount);
		  payload.addAlert(message);
		  payload.addSound("default");
		  if(dict != null)
		  {
			 Set<String> keys=  dict.keySet();
			 for(String k : keys)
			 {
				 Object o = dict.get(k);
				 
				 if(o instanceof String)
				 {
					 payload.addCustomDictionary(k, (String)o);
				 }else if(o instanceof Number)
				 {
					 payload.addCustomDictionary(k, ((Number)o).intValue());
				 }else if(o instanceof List)
				 {
					 payload.addCustomDictionary(k, (List<?>)o);
				 }
			 }
		  }
		  
		  return Push.payload(payload, keystore, password, production, deviceToken);
		  
		
	}
	
	 public static List<Device> feedback(Object keystore, String password, boolean production) throws CommunicationException, KeystoreException{
		 return Push.feedback(keystore, password, production);
	 }
}
