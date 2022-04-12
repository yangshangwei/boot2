package com.artisan;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 项目修改器，一键替换 Maven 的 groupId、artifactId，项目的 package 等
 * <p>
 * 通过修改 groupIdNew、artifactIdNew、projectBaseDirNew 三个变量
 *
 * @author 芋道源码
 */
@Slf4j
public class ProjectReactor {

    private static final String GROUP_ID = "com.zfsoft";
    private static final String ARTIFACT_ID = "zhongfu";
    private static final String PACKAGE_NAME = "com.zfsoft.base";

    public static void main(String[] args) {
        String projectBaseDir = getProjectBaseDir();
        replaceDir("D:\\IdeaProjects\\ruoyi-vue-pro-bak");

        log.info("[main][重写完成]");
    }

    private static String getProjectBaseDir() {
        // noinspection ConstantConditions
        return StrUtil.subBefore(ProjectReactor.class.getClassLoader().getResource("").getFile(),
                "/zhongfu-server", false);
    }




    public static void replaceDir(String projectBaseDir) {
        Collection<File> files = FileUtils.listFiles(new File(projectBaseDir), null, true);



        Collection<File> files1 = FileUtils.listFilesAndDirs(new File("D:\\IdeaProjects\\ruoyi-vue-pro-bak"), new IOFileFilter() {
            @Override
            public boolean accept(File file) {
                return false;
            }

            @Override
            public boolean accept(File file, String s) {
                return false;
            }
        }, new IOFileFilter() {
            @Override
            public boolean accept(File file) {
                return false;
            }

            @Override
            public boolean accept(File file, String s) {
                return false;
            }
        });
        System.out.println(files1.size());

    }
}
