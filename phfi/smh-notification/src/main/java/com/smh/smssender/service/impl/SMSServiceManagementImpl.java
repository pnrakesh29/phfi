package com.smh.smssender.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.smssender.service.SMSProps;
import com.smh.smssender.service.SMSServiceManagement;


@Service("smsServiceManagement")
public class SMSServiceManagementImpl implements SMSServiceManagement {

	private static Logger logger = Logger.getLogger(SMSServiceManagementImpl.class);
	
	@Autowired
	SMSProps smsProps;
	
	/*public boolean sendSMS(final String smsTo, final String smsBody, final List<String> smsTemplateParameters) {
		try {
			new Thread(new Runnable() {
				public void run() {
					logger.info("-------------------------Start SMS Service Invoke---------------------------------");
					SMSServiceClient serviceClient = SMSServiceClient.get();
					SMSThreadLocal.add(serviceClient);
					serviceClient.sendSMS(smsProps.getSmsGatewayServiceBaseUrl(),
							smsProps.getSmsGatewayServiceApiKey(),
							smsProps.getSmsGatewayServiceApiSecret(),
							smsProps.getSmsGatewayServiceConTimeout(),
							smsProps.getSmsGatewayServiceSoTimeout(), 
							smsProps.getSmsGatewayServiceFrom(),
							smsProps.getSmsGatewaySenderId(),
							smsTo, smsBody, smsTemplateParameters);
					logger.info("-------------------------End SMS Service Invoke---------------------------------");
				}
			}).start();
		} catch (Exception e) {
			logger.info("------------------ERRRRRROR from SMS Service---------------------");
		}
		return true;
	}*/
	public boolean sendSMS(final String smsTo, final String smsBody) {
		try {
			new Thread(new Runnable() {
				public void run() {
					logger.info("-------------------------Start SMS Service Invoke---------------------------------");
					SMSServiceClient serviceClient = SMSServiceClient.get();
					SMSThreadLocal.add(serviceClient);
					serviceClient.sendSMS(smsProps.getSmsGatewayServiceBaseUrl(),
							smsProps.getSmsGatewayServiceUserName(),
							smsProps.getSmsGatewayServicePassword(),
							smsProps.getSmsGatewayServiceSend(),
							smsProps.getSmsGatewayServicePriority(), 
							smsProps.getSmsGatewayServiceVP(),
							smsProps.getSmsGatewaySenderConcat(),
							smsProps.getSmsGatewayServiceConTimeout(),
							smsProps.getSmsGatewayServiceSoTimeout(),
							smsTo, smsBody);
					logger.info("-------------------------End SMS Service Invoke---------------------------------");
				}
			}).start();
		} catch (Exception e) {
			logger.info("------------------ERRRRRROR from SMS Service---------------------");
		}
		return true;
	}
}
