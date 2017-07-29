/**
 * HellowWorldImpLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ywx.imp;

public class HellowWorldImpLocator extends org.apache.axis.client.Service implements com.ywx.imp.HellowWorldImp {

    public HellowWorldImpLocator() {
    }


    public HellowWorldImpLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HellowWorldImpLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HellowWorldImpPort
    private java.lang.String HellowWorldImpPort_address = "http://192.168.92.83:9090/webyks";

    public java.lang.String getHellowWorldImpPortAddress() {
        return HellowWorldImpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HellowWorldImpPortWSDDServiceName = "HellowWorldImpPort";

    public java.lang.String getHellowWorldImpPortWSDDServiceName() {
        return HellowWorldImpPortWSDDServiceName;
    }

    public void setHellowWorldImpPortWSDDServiceName(java.lang.String name) {
        HellowWorldImpPortWSDDServiceName = name;
    }

    public com.ywx.HelloWorld getHellowWorldImpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HellowWorldImpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHellowWorldImpPort(endpoint);
    }

    public com.ywx.HelloWorld getHellowWorldImpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ywx.imp.HellowWorldImpPortBindingStub _stub = new com.ywx.imp.HellowWorldImpPortBindingStub(portAddress, this);
            _stub.setPortName(getHellowWorldImpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHellowWorldImpPortEndpointAddress(java.lang.String address) {
        HellowWorldImpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ywx.HelloWorld.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ywx.imp.HellowWorldImpPortBindingStub _stub = new com.ywx.imp.HellowWorldImpPortBindingStub(new java.net.URL(HellowWorldImpPort_address), this);
                _stub.setPortName(getHellowWorldImpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HellowWorldImpPort".equals(inputPortName)) {
            return getHellowWorldImpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://imp.ywx.com/", "HellowWorldImp");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://imp.ywx.com/", "HellowWorldImpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HellowWorldImpPort".equals(portName)) {
            setHellowWorldImpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
