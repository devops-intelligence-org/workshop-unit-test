package com.domain.util;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.domain.models.ProductResponse;

public class PingTest {

   
    Ping ping = new Ping();

    @Test
    void testSendPingRequest() throws IOException {
        String message ="Sent Ping Request to 127.0.0.1: Host is reachable"; 
        String respuestaPing = ping.sendPingRequest("127.0.0.1");
        Assertions.assertEquals(message, respuestaPing);
    }
}