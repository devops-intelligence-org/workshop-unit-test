package com.domain.util;
import java.io.*; 
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Ping {

Logger logger = LoggerFactory.getLogger(Ping.class);

    public String sendPingRequest(String ipAddress) throws IOException 
{ 
	InetAddress geek = InetAddress.getByName(ipAddress); 
    String message;
    message ="Sent Ping Request to " + ipAddress;
	if (geek.isReachable(5000)) 
	message+=": Hurray! host is reachable"; 
	else
	message+=": We really sorry! We can't reach to this host"; 
    logger.info(message);
    return message;
} 


} 
