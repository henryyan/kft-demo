package me.kafeitu.kftdemo.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 三寻
 * @version 1.0
 * @date 2019-02-11
 */
@RestController
public class MainController {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/")
    public String hello() {
        InetAddress ip;
        String hostname = "unknown";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String ct = "Hello, server name: %s, server time: %s";
        return String.format(ct, hostname, sdf.format(new Date()));
    }
}
