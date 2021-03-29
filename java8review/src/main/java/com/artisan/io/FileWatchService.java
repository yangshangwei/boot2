package com.artisan.io;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/9 15:11
 * @mark: show me the code , change the world
 */
public class FileWatchService {

    public static void main(String[] args) throws Exception {
        final FileSystem fileSystem = FileSystems.getDefault();
        try (final WatchService watchService = fileSystem.newWatchService()) {
            final Map<WatchKey, Path> keyMap = new HashMap<WatchKey, Path>();
            final Path path = Paths.get("C:\\Users\\artisan\\Desktop\\Test");
            keyMap.put(path.register(watchService, ENTRY_CREATE,ENTRY_DELETE),path);
            WatchKey watchKey;
            do {
                watchKey = watchService.take();
                final Path eventDir = keyMap.get(watchKey);
                for (final WatchEvent<?> event : watchKey.pollEvents()) {
                    final WatchEvent.Kind kind = event.kind();
                    final Path eventPath = (Path) event.context();
                    System.out.println(Thread.currentThread().getName() +  ":" + eventDir + ": " + kind + ": " + eventPath);

                    System.out.println("休眠开始");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("休眠结束");
                }
            } while (watchKey.reset());
        }
    }
}
    