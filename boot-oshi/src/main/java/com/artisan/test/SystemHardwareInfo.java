package com.artisan.test;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/24 15:16
 * @mark: show me the code , change the world
 */

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.NumberUtil;
import com.artisan.entity.*;
import lombok.Data;
import lombok.SneakyThrows;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Data
public class SystemHardwareInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int OSHI_WAIT_SECOND = 1000;

    /**
     * CPU相关信息
     */
    private Cpu cpu = new Cpu();

    /**
     * 內存相关信息
     */
    private Mem mem = new Mem();

    /**
     * JVM相关信息
     */
    private Jvm jvm = new Jvm();

    /**
     * 服务器相关信息
     */
    private Sys sys = new Sys();

    /**
     * 磁盘相关信息
     */
    private List<SysFile> sysFiles = new LinkedList<SysFile>();



    /**
     * 设置CPU信息
     */
    private void setCpuInfo(CentralProcessor processor) {
        // CPU信息
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(OSHI_WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
        long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
        long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
        long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
        long cSys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
        long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
        long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
        long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        cpu.setCpuNum(processor.getLogicalProcessorCount());
        cpu.setTotal(totalCpu);
        cpu.setSys(cSys);
        cpu.setUsed(user);
        cpu.setWait(iowait);
        cpu.setFree(idle);

        System.out.println(cpu.toString());
    }

    /**
     * 设置内存信息
     */
    private void setMemInfo(GlobalMemory memory) {
        mem.setTotal(memory.getTotal());
        mem.setUsed(memory.getTotal() - memory.getAvailable());
        mem.setFree(memory.getAvailable());

        System.out.println(mem.toString());

    }

    /**
     * 设置服务器信息
     */
    private void setSysInfo() {
        Properties props = System.getProperties();
        //  sys.setComputerName(IpUtil.getHostName());
        sys.setComputerName(NetUtil.getLocalhostStr());
        sys.setComputerIp(NetUtil.getLocalhostStr());
        sys.setOsName(props.getProperty("os.name"));
        sys.setOsArch(props.getProperty("os.arch"));
        sys.setUserDir(props.getProperty("user.dir"));

        System.out.println(sys.toString());

    }

    /**
     * 设置Java虚拟机
     */
    private void setJvmInfo() {
        Properties props = System.getProperties();
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        jvm.setMax(Runtime.getRuntime().maxMemory());
        jvm.setFree(Runtime.getRuntime().freeMemory());
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));

        System.out.println(jvm.toString());

    }

    /**
     * 设置磁盘信息
     */
    private void setSysFiles(OperatingSystem os) {
        FileSystem fileSystem = os.getFileSystem();
//        OSFileStore[] fsArray = fileSystem.getFileStores();
//        for (OSFileStore fs : fsArray) {
//            long free = fs.getUsableSpace();
//            long total = fs.getTotalSpace();
//            long used = total - free;
//            SysFile sysFile = new SysFile();
//            sysFile.setDirName(fs.getMount());
//            sysFile.setSysTypeName(fs.getType());
//            sysFile.setTypeName(fs.getName());
//            sysFile.setTotal(convertFileSize(total));
//            sysFile.setFree(convertFileSize(free));
//            sysFile.setUsed(convertFileSize(used));
//            sysFile.setUsage(NumberUtil.round(NumberUtil.mul(used, total, 4), 100).doubleValue());
//            sysFiles.add(sysFile);
//
//            System.out.println(sysFiles.toString());
//
//        }


    }

    /**
     * 字节转换
     *
     * @param size 字节大小
     * @return 转换后值
     */
    public String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }



    public void copyTo() throws Exception {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        setCpuInfo(hal.getProcessor());

        setMemInfo(hal.getMemory());

        setSysInfo();

        setJvmInfo();

        setSysFiles(si.getOperatingSystem());
    }

    @SneakyThrows
    public static void main(String[] args) {
        SystemHardwareInfo systemHardwareInfo = new SystemHardwareInfo();
        systemHardwareInfo.copyTo();

    }
}