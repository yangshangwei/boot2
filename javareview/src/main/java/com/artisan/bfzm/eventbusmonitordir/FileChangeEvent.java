package com.artisan.bfzm.eventbusmonitordir;


import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 16:38
 * @mark: show me the code , change the world
 */
public class FileChangeEvent {

    private final Path path;
    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }

    public Path getPath() {
        return path;
    }

    public WatchEvent.Kind<?> getKind() {
        return kind;
    }
}
    