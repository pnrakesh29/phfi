package com.smh.smssender.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.Logger;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class SMSServiceClient {

	private static Logger logger = Logger.getLogger(SMSServiceClient.class);
	/*
	private static final String URL_PARAM_SEPARATOR = "&";
	private static final String EQUALS = "=";
	*/
	private HttpClient httpClient;

	private static ThreadLocal threadLocal = new ThreadLocal() {
		@Override
		protected SMSServiceClient initialValue() {
			return new SMSServiceClient();
		}

	};

	public static SMSServiceClient get() {
		return (SMSServiceClient) threadLocal.get();
	}

/*	public void sendSMS(String baseUrl, final String apiKey,
			final String apiSecret, final int connectionTimeout,
			final int soTimeout, final String smsFrom,final String senderId, final String smsTo,
			final String smsBody, final List<String> smsTemplateParameters) {
		callWay2MintSMSService(baseUrl, apiKey, apiSecret, connectionTimeout,
				soTimeout,senderId, smsTo,smsBody, smsTemplateParameters);

	}*/

	public void sendSMS(String baseUrl, final String userName,
			final String password, final String send,
			final String priority, final String vp,final String concat, final int connectionTimeout,
			final int soTimeout, final String smsTo,
			final String smsBody) {
		callWay2MintSMSService(baseUrl, userName, password, send,
				priority, vp, concat, connectionTimeout, soTimeout, smsTo, smsBody);

	}
	
/*	private void callWay2MintSMSService(String baseUrl, final String apiKey,
			final String apiSecret, final int connectionTimeout,
			final int soTimeout,final String senderId, final String smsTo, final String smsTemplate, final List<String> smsTemplateParameters) {
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("username", apiKey));
			params.add(new BasicNameValuePair("password", apiSecret));
			params.add(new BasicNameValuePair("destination", smsTo));
			params.add(new BasicNameValuePair("template_name", smsTemplate));

			params = getWay2MintParams(smsTemplateParameters, params);
			
			params.add(new BasicNameValuePair("response_format", "json"));
			params.add(new BasicNameValuePair("sender_id", senderId));
			
			System.out.println(params);
			
			
			HttpUriRequest method = null;
			HttpPost httpPost = new HttpPost(baseUrl);
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			method = httpPost;
			HttpResponse httpResponse = getNewHttpClient(connectionTimeout,
					soTimeout).execute(method);
			int status = httpResponse.getStatusLine().getStatusCode();

			System.out.println("status: " + status);
			String response = new BasicResponseHandler()
					.handleResponse(httpResponse);
			System.out.println("--------------------------");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	private void callWay2MintSMSService(String baseUrl, final String userName,
			final String password, final String send,
			final String priority, final String vp,final String concat, final int connectionTimeout,
			final int soTimeout, final String smsTo,
			final String smsBody) {
		try {
			if (!baseUrl.endsWith("?"))
				baseUrl += "?";
			 
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("uname", userName));
			params.add(new BasicNameValuePair("pass", password));
			params.add(new BasicNameValuePair("send", send));
			params.add(new BasicNameValuePair("dest", smsTo));
			params.add(new BasicNameValuePair("msg", smsBody));
			if (smsBody.length() <= 160) {
				params.add(new BasicNameValuePair("prty", priority));
				params.add(new BasicNameValuePair("vp", vp));	
			} else if (smsBody.length() > 160) {
				params.add(new BasicNameValuePair("concat", concat));
			}

			System.out.println(params);
			
			String paramString = URLEncodedUtils.format(params, "UTF-8");
			HttpGet httpGet = new HttpGet(baseUrl + paramString);
			HttpResponse httpResponse = getNewHttpClient(connectionTimeout, soTimeout).execute(httpGet);
			int status = httpResponse.getStatusLine().getStatusCode();
			
			logger.info("Message sent successfully");
			System.out.println("status: " + status);
			String response = new BasicResponseHandler().handleResponse(httpResponse);
			System.out.println("--------------------------");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in sending SMS" + e);
		}
	}
	
	public HttpClient getNewHttpClient(final int connectionTimeout,
			final int soTimeout) {
		if (null == httpClient) {
			HttpParams httpClientParams = new BasicHttpParams();
			HttpProtocolParams.setUserAgent(httpClientParams,
					"Nexmo Java SDK 1.4");
			HttpConnectionParams.setConnectionTimeout(httpClientParams,
					connectionTimeout);
			HttpConnectionParams.setSoTimeout(httpClientParams, soTimeout);
			HttpConnectionParams
					.setStaleCheckingEnabled(httpClientParams, true);
			HttpConnectionParams.setTcpNoDelay(httpClientParams, true);
			httpClient = new DefaultHttpClient(
					new ThreadSafeClientConnManager(), httpClientParams);
		}
		return httpClient;
	}

	public static List<NameValuePair> getWay2MintParams(List<String> smsTemplateParameters, List<NameValuePair> params) {
		
		if(smsTemplateParameters == null || smsTemplateParameters.isEmpty()) {
			return params;
		}
		String WAY2MINT_PARAMS = "ABCDEFGHIJKLM";
		String WAY2MINT_PARAMS_NAME = "templateParameters";
		for (int k=0; k<smsTemplateParameters.size(); k++) {
			String param = smsTemplateParameters.get(k);
			params.add(new BasicNameValuePair((WAY2MINT_PARAMS_NAME + "["
					+ WAY2MINT_PARAMS.charAt(k) + "]"), param));
		}
		return params;
	}
}
