package com.test.socketlocal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
//先运行服务端，后客户端
public class WeatherClient {
	 public static void main(String[] args) throws UnknownHostException, IOException{
	//1.创建Socket对象，和服务端建立连接
    Socket socket = new Socket("192.168.92.83",9092);
     
    //2.发送城市名称
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    dos.writeUTF("北京");
    System.out.println("请求查询天气: 北京");
     
    //3.接受返回结果使用输入流
    DataInputStream dis = new DataInputStream(socket.getInputStream());
    String result = dis.readUTF();
    System.out.println("北京的天气: " + result);
     
    //4.关闭流
    dis.close();
    dos.close();
    socket.close();
	 }
}
