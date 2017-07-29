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

@WebService
public interface HelloWorld {
	//接收请求参数体为json的post请求,非json的get请求
    String sayHi(String text)  throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException;
  //接收请求参数体为数组的get/post请求
    String postGetArray(String text)  throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException;
}
// END SNIPPET: service
