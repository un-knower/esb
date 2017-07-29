package com.ywx.test;

import java.rmi.RemoteException;

import com.ywx.HelloWorldProxy;

public class TestHelloService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorldProxy h = new HelloWorldProxy();  
        try {  
            String s = h.sayHi("ysk's first webservice");  
            System.out.println("调--webservice---:"+s);  
        } catch (RemoteException e) {  
            e.printStackTrace();  
        }  

	}

}
