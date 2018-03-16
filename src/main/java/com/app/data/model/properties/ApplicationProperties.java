/**
 * @desc	Properties file is loaded in bean class
 * @methods	Setters, Getters
 * @author	kavesh.shetgaonkar
 * @date	Sept 18, 2017
 */
package com.app.data.model.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:${files.location}/commons.properties")
public class ApplicationProperties {

	@Value("${Server.File.Path}")
	private String serverConfigUrl;
	
	@Value("${Email.Template.Dir}")
	private String emailTemplate;
	
	@Value("${OTPExpiryTimeInMin}")
	private int otpExpTimeMin;
	
	@Value("${Private.key.file}")
	private String privateKeyPath;
	
	@Value("${Alert.ExecutionInterval}")
	private int alertExecutionTime;
	
	public String getServerConfigUrl() {
		return serverConfigUrl;
	}
	public void setServerConfigUrl(String serverConfigUrl) {
		this.serverConfigUrl = serverConfigUrl;
	}
	
	public String getEmailTemplate() {
		return emailTemplate;
	}
	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}
	
	public int getOtpExpTimeMin() {
		return otpExpTimeMin;
	}
	public void setOtpExpTimeMin(int otpExpTimeMin) {
		this.otpExpTimeMin = otpExpTimeMin;
	}
	
	public String getPrivateKeyPath() {
		return privateKeyPath;
	}
	public void setPrivateKeyPath(String privateKeyPath) {
		this.privateKeyPath = privateKeyPath;
	}
	
	public int getAlertExecutionTime() {
		return alertExecutionTime;
	}
	public void setAlertExecutionTime(int alertExecutionTime) {
		this.alertExecutionTime = alertExecutionTime;
	}
	
}
