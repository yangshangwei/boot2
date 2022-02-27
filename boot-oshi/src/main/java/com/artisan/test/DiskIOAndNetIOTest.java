package com.artisan.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 小工匠
 * @version 1.0
 * @description: https://blog.csdn.net/m0_37768362/article/details/71525393
 * @date 2022/2/26 18:42
 * @mark: show me the code , change the world
 */
public class DiskIOAndNetIOTest {


    public static JSONArray getDiskIORate() {

        String info = "iostat -d -x 1 2";

        String diskName = null;
        double rkb = 0.0;
        double wkb = 0.0;
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String[] data = info.split("\n");
        for (int i = 7; i < data.length; i++) {
            String[] numdata = data[i].split(" +");
            //磁盘名称
            diskName = numdata[0];
            //磁盘读数据速率
            rkb = Double.parseDouble(numdata[5]);
            //磁盘写数据速率
            wkb = Double.parseDouble(numdata[6]);
            json.put("diskName", diskName);
            json.put("rkb", rkb);
            json.put("wkb", wkb);
            jsonArray.add(json);
        }
        return jsonArray;
    }


    public static JSONArray getNetIO() {

        String CMD = "cat /proc/net/dev";

        String info1 = null;
        String info2 = null;
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            info1 = Runcommand.runCommand(CMD);
            //隔一秒再执行一次
            Thread.sleep(1000);
            info2 = Runcommand.runCommand(CMD);
            System.out.println(info1);
            System.out.println(info2);
        } catch (Exception e) {
            // TODO: handle exception
        }

        String[] data1 = info1.split("\n");
        String[] data2 = info2.split("\n");
        int receiveBytes1 = 0;
        int transmitBytes1 = 0;
        int receiveBytes2 = 0;
        int transmitBytes2 = 0;
        for (int i = 2; i < data1.length; i++) {
            String[] numdata1 = data1[i].trim().split(" +");
            String[] numdata2 = data2[i].trim().split(" +");
            receiveBytes1 = Integer.parseInt(numdata1[1]);
            transmitBytes1 = Integer.parseInt(numdata1[9]);
            receiveBytes2 = Integer.parseInt(numdata2[1]);
            transmitBytes2 = Integer.parseInt(numdata2[9]);

            int receiveBytes = receiveBytes2 - receiveBytes1;
            int transmitBytes = transmitBytes2 - transmitBytes1;
            //端口名称
            json.put("Interface", numdata1[0]);
            //端口一秒内接收的字节数
            json.put("receiveBytes", receiveBytes);
            //端口一秒内发送的字节数
            json.put("transmitBytes", transmitBytes);
            jsonArray.add(json);
            System.out.println(numdata1[0] + " receiveBytes:" + receiveBytes + " bytes transmitBytes:" + transmitBytes + " bytes");
        }
        //返回json数组
        return jsonArray;
    }


    public static void main(String[] args) {
        System.out.println(getDiskIORate());

        System.out.println(getNetIO());

    }
}
    