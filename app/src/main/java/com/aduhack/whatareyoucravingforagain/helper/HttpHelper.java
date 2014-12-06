package com.aduhack.whatareyoucravingforagain.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpHelper {

	public boolean wifiConnected = false;
	public boolean mobileConnected = false;
	public boolean isConnected = false;

	public void updateConnectedFlags(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
		if (activeInfo != null && activeInfo.isConnected()) {
			this.wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
			this.mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
		} else {
			this.wifiConnected = false;
			this.mobileConnected = false;
		}
	}

	public boolean isWifiConnected() {
		return wifiConnected;
	}

	public boolean isMobileConnected() {
		return mobileConnected;
	}
	
	public boolean isConnected() {
		return mobileConnected || wifiConnected;
	}


	// GET With Header
	public String getResponseWithHeader(String fulldomain, String token) {
		HttpResponse httpResponse;
		HttpEntity httpEntity = null;
		String jsonResult = "";
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(fulldomain);
			get.setHeader("Content-Type", "application/json");
			get.setHeader("Authorization", "Bearer " + token);
			httpResponse = httpClient.execute(get);
			httpEntity = httpResponse.getEntity();
			jsonResult = EntityUtils.toString(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	// GET
	public HttpEntity getResponse(String fulldomain) {
		HttpResponse httpResponse;
		HttpEntity httpEntity = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(fulldomain);
			httpResponse = httpClient.execute(get);
			httpEntity = httpResponse.getEntity();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return httpEntity;
	}

	// POST
	public HttpEntity postResponse(String fulldomain) {
		HttpResponse httpResponse;
		HttpEntity httpEntity = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpPost = new HttpGet(fulldomain);
			httpResponse = httpClient.execute(httpPost);
			httpEntity = httpResponse.getEntity();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpEntity;
	}
}
