package com.artisan.controller;

import com.artisan.annos.NotConflictArtisan;
import com.artisan.annos.UniqueArtisan;
import com.artisan.bean.Artisan;
import com.artisan.repository.ArtisanDao;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping("/buziVa/artisan")
@Slf4j
@Validated
public class ArtisanController {

    @Autowired
    private ArtisanDao artisanDao;


    // POST 方法
    @PostMapping
    public Artisan createUser(@UniqueArtisan @Valid Artisan user) {
        Artisan savedUser = artisanDao.save(user);
        log.info("save user id is {}", savedUser.getId());
        return savedUser;
    }

    // PUT
    @SneakyThrows
    @PutMapping
    public Artisan updateUser(@NotConflictArtisan @Valid @RequestBody Artisan artisan) {
        Artisan editUser = artisanDao.save(artisan);
        log.info("update artisan is {}", editUser);
        return editUser;
    }

}
