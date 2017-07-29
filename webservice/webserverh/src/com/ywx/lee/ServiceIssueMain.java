package com.ywx.lee;

import javax.xml.ws.Endpoint;

import com.ywx.HelloWorld;
import com.ywx.imp.HellowWorldImp;

public class ServiceIssueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HelloWorld hw = new HellowWorldImp();  
	        //调用Endpoint的publish方法发布Web Service  
	        Endpoint.publish("http://192.168.92.83:9090/webyks", hw);  
	        System.out.println("Web Service暴露成功！"); 

	}

}
