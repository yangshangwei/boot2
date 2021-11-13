package com.artisan.ssh;

/**
 * @author 小工匠
 * @version 1.0
 * @description:
 * @date 2021/8/16 15:56
 * @mark: show me the code , change the world
 * https://blog.csdn.net/qq_34021712/article/details/66972672
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

/**
 * java远程上传文件
 * @author lenovo
 *
 */
public class SSHUtil {

    private String host;

    private String user;

    private String password;

    private int port;

    private Session session;

    /**
     * 创建一个连接
     *
     * @param host
     *            地址
     * @param user
     *            用户名
     * @param password
     *            密码
     * @param port
     *            ssh2端口
     */
    public SSHUtil(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    private void initialSession() throws Exception {
        if (session == null) {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setUserInfo(new UserInfo() {

                @Override
                public String getPassphrase() {
                    return null;
                }
                @Override
                public String getPassword() {
                    return null;
                }
                @Override
                public boolean promptPassword(String arg0) {
                    return false;
                }
                @Override
                public boolean promptPassphrase(String arg0) {
                    return false;
                }
                @Override
                public boolean promptYesNo(String arg0) {
                    return true;
                }
                @Override
                public void showMessage(String arg0) {
                }

            });
            session.setPassword(password);
            session.connect();
        }
    }

    /**
     * 关闭连接
     *
     * @throws Exception
     */
    public void close() throws Exception {
        if (session != null && session.isConnected()) {
            session.disconnect();
            session = null;
        }
    }

    /**
     * 上传文件
     *
     * @param localPath
     *            本地路径，若为空，表示当前路径
     * @param localFile
     *            本地文件名，若为空或是“*”，表示目前下全部文件
     * @param remotePath
     *            远程路径，若为空，表示当前路径，若服务器上无此目录，则会自动创建
     * @throws Exception
     */
    public void putFile(String localPath, String localFile, String remotePath)
            throws Exception {
        this.initialSession();
        Channel channelSftp = session.openChannel("sftp");
        channelSftp.connect();
        ChannelSftp c = (ChannelSftp) channelSftp;
        String remoteFile = null;
        if (remotePath != null && remotePath.trim().length() > 0) {
            try {
                c.mkdir(remotePath);
            } catch (Exception e) {
            }
            remoteFile = remotePath + "/.";
        } else {
            remoteFile = ".";
        }
        String file = null;
        if (localFile == null || localFile.trim().length() == 0) {
            file = "*";
        } else {
            file = localFile;
        }
        if (localPath != null && localPath.trim().length() > 0) {
            if (localPath.endsWith("/")) {
                file = localPath + file;
            } else {
                file = localPath + "/" + file;
            }
        }
        c.put(file, remoteFile);

        channelSftp.disconnect();
    }


    // command 命令
    public String runCommand(String command) throws Exception {
        // CommonUtil.printLogging("[" + command + "] begin", host, user);

        this.initialSession();
        InputStream in = null;
        InputStream err = null;
        BufferedReader inReader = null;
        BufferedReader errReader = null;
        int time = 0;
        String s = null;
        boolean run = false;
        StringBuffer sb = new StringBuffer();

        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand(command);
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(null);
        err = ((ChannelExec) channel).getErrStream();
        in = channel.getInputStream();
        channel.connect();
        inReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        errReader = new BufferedReader(new InputStreamReader(err, "UTF-8"));

        while (true) {
            s = errReader.readLine();
            if (s != null) {
                sb.append("error:" + s).append("\n");
            } else {
                run = true;
                break;
            }
        }
        while (true) {
            s = inReader.readLine();
            if (s != null) {
                sb.append("info:" + s).append("\n");
            } else {
                run = true;
                break;
            }
        }

        while (true) {
            if (channel.isClosed() || run) {
                // CommonUtil.printLogging("[" + command + "] finish: " +
                // channel.getExitStatus(), host, user);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
            if (time > 180) {
                // CommonUtil.printLogging("[" + command + "] finish2: " +
                // channel.getExitStatus(), host, user);
                break;
            }
            time++;
        }

        inReader.close();
        errReader.close();
        channel.disconnect();
        session.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        SSHUtil ssh2Util = new SSHUtil("1.117.97.88", "artisan","artisan", 22);
//        ssh2Util.putFile("D:\\BaiduNetdiskDownload", "jdk-8u11-linux-x64.rpm","/home/artisan/testUpload");

        ssh2Util.runCommand("cd /home/artisan;pwd");
    }


}