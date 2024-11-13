package com.domain.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.domain.controller.BankingController;
import com.domain.models.ProductResponse;

class PingTest {
 
    Ping ping = new Ping();

    @Test
    void testSendPingRequest() throws IOException {
        String message ="Sent Ping Request to 127.0.0.1: Hurray! host is reachable"; 
        String respuestaPing = ping.sendPingRequest("127.0.0.1");
        Assertions.assertEquals(message, respuestaPing);
    }

    @Test
    void testSendPingRequestInvalid() throws IOException {
        String message ="Sent Ping Request to 127.0.0.1: We really sorry! We can't reach to this host"; 
        String respuestaPing = ping.sendPingRequest("127.0.0.1");
        Assertions.assertNotNull(message, respuestaPing);
    }

    @Test
    void testSendPingRequestNull() throws IOException {
        String message ="Sent Ping Request to 0.0.0.1: We really sorry! We can't reach to this host"; 
        String respuestaPing = ping.sendPingRequest("0.0.0.1");
        Assertions.assertEquals(message, respuestaPing);
    }

}