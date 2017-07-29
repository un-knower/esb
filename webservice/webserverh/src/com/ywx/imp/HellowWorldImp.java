package com.ywx.imp;



import java.util.Date;

import javax.jws.WebService;

import com.ywx.HelloWorld;
@WebService(endpointInterface="com.ywx.HelloWorld",serviceName="HellowWorldImp")//指定webservice所实现的接口以及服务名称  
public class HellowWorldImp implements HelloWorld{
	 public String sayHi(String name) {  
	        return name+"您好！现在时间是："+new Date();  
	    } 

}
