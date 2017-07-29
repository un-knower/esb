/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// START SNIPPET: service
package org.apache.servicemix.examples.cxf;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.jws.WebService;

import org.apache.http.ParseException;

@WebService(endpointInterface = "org.apache.servicemix.examples.cxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	//接收请求参数体为json的post请求,非json的get请求
    public String sayHi(String text) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
    	String result ="服务端返回内容:<br/>请求url-----<br/>"+text;
    	//拆分请求参数为数组
    	String[] requestparam = text.trim().split("#");
    	//返回结果
    	String[] responseResult = {"",""};
    	HttpPostGetUtil hpost = new HttpPostGetUtil();
    	responseResult = hpost.postGetJsonRedirect(requestparam);
    	result+="<br/>-----status code of server client-----:"+responseResult[0]+"<br/><br/>----return back results-----:<br/>"+responseResult[1];
        return result;
    }
    //接收请求参数体为数组的get/post请求
    public String postGetArray(String text) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
    	String result ="服务端返回内容：<br/>请求url-----:<br/>"+text;
    	//拆分请求参数为数组
    	String[] requestparam = text.trim().split("#");
    	//返回结果
    	String[] responseResult = {"",""};
    	HttpPostGetUtil hpost = new HttpPostGetUtil();
    	responseResult = hpost.postGetArrayRedirect(requestparam);
    	result+="<br/>-----status code of server client-----:"+responseResult[0]+"<br/><br/>----return back results-----:<br/>"+responseResult[1];
        return result;
    }
}
// END SNIPPET: service
