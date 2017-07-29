package com.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 接收get/post请求
 *
 */
public class MyHttpPosGettUtilm {
	
	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
		String[] responseResult = {"",""};
		//HttpPosGettUtilm html = new HttpPosGettUtilm();
		new MyHttpPosGettUtilm().postGetArrayRedirect(responseResult);
	}
	//接收请求参数体为json的post请求,非json的get请求
	public String[] postGetJsonRedirect(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
		//返回的结果
		String[] responseResult = {"",""};
		String charset = "utf-8";
		String usrpwd="";
		@SuppressWarnings("deprecation")
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
				return true;
			}
		}).build();

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		
		if(args.length>4){
			//发送post请求
			HttpPost request  = new HttpPost(args[0]);
			//设置发送请求体格式:json
			request.addHeader(args[1], args[2]);
			usrpwd = "{\""+args[3]+"\":\""+args[4]+"\",\""+args[5]+"\":\""+args[6]+"\"}";
			//添加请求认证用户名和密码
			request.setEntity(new StringEntity(usrpwd));
			HttpResponse response = httpClient.execute(request);
			//转发到真实服务后，返回的状态(转发成功:200或失败:0)
			responseResult[0] = response.getStatusLine().getStatusCode()+"";
			//转发到真实服务后，返回的数据(json格式)
			responseResult[1] = EntityUtils.toString(response.getEntity(), charset);
		}else{
			HttpGet request = new HttpGet(args[0]);
			//添加请求认证token
			//request.setParams(new BasicHttpParams().setParameter(args[1], args[2]) );
			HttpResponse response = httpClient.execute(request);
			//转发到真实服务后，返回的状态(转发成功:200或失败:0)
			responseResult[0] = response.getStatusLine().getStatusCode()+"";
			//转发到真实服务后，返回的数据(json格式)
			responseResult[1] = EntityUtils.toString(response.getEntity(), charset);
			
		}
		return responseResult;
	}
	//接收请求参数体为数组的get/post请求
	public  String[] postGetArrayRedirect(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
		//返回的结果
		String[] responseResult = {"",""};
		String url = "http://skuimg.kokoerp.com/api/?c=api_pictureurl_urlservers&a=get_pictureurl";
		String charset = "utf-8";
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
				return true;
			}
		}).build();

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		HttpPost request = new HttpPost(url);
		//request.addHeader("Content-Type", "application/json");
		// 创建参数队列    
        List<NameValuePair> listparams = new ArrayList<NameValuePair>(); 
        //添加参数
        listparams.add(new BasicNameValuePair("sku", "A301")); 
        listparams.add(new BasicNameValuePair("gallery_id", "1")); 
        listparams.add(new BasicNameValuePair("type", "D")); 
        listparams.add(new BasicNameValuePair("all_type", "false")); 
        listparams.add(new BasicNameValuePair("url_type", "http")); 
//        for(int j=1;j<args.length;j+=2)
//        	 listparams.add(new BasicNameValuePair(args[j], args[j+1])); 
        //url参数
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(listparams,charset); 
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		//System.out.println("状态：" + response.getStatusLine().getStatusCode());
		//System.out.println("data：" + EntityUtils.toString(response.getEntity(), charset));
		//转发到真实服务后，返回的状态(转发成功:200或失败:0)
		responseResult[0] = response.getStatusLine().getStatusCode()+"";
		System.out.println("------没错-----");
		//转发到真实服务后，返回的数据(json格式)
		responseResult[1] = EntityUtils.toString(response.getEntity(), charset);
		System.out.println("状态：" + responseResult[0]);
		System.out.println("data：" + responseResult[1]);
		return responseResult;
	}
	
}
