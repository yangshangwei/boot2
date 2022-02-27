package com.artisan.test;

import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/24 15:41
 * @mark: show me the code , change the world
 */
public class OsHi561Test {

    public static void main(String[] args) {
//        long total = OshiUtil.getMemory().getTotal();
//
//        CpuInfo cpuInfo = OshiUtil.getCpuInfo();


        System.out.println(SystemUtil.getHostInfo());
        System.out.println(SystemUtil.getUserInfo());
        System.out.println(OshiUtil.getCpuInfo().getCpuModel());

    }
}
    