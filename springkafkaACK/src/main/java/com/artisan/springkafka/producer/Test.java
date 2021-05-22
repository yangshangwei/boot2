package com.artisan.springkafka.producer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/19 15:37
 * @mark: show me the code , change the world
 */
public class Test {


    public static void main(String[] args) throws IOException {
     //   getRealIp();

        getIP();
    }


    public static void getIP() throws IllegalStateException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://ifconfig.me/");
        request.setHeader("User-Agent","curl/7.16.3 (i686-pc-cygwin) libcurl/7.16.3 OpenSSL/0.9.8h zlib/1.2.3 libssh2/0.15-CVS");
        HttpResponse response = client.execute(request);

        // Get the response
        String addr = IOUtils.toString(new InputStreamReader(response.getEntity().getContent()));
        System.out.println(addr);
    }


    public static  String getRealIp() throws SocketException {

        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP

        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }
        System.out.println("外网IP" + netip);
        System.out.println("本地IP:" + localip);
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }




    }
    