package com.artisan.startvalidator.controller;

import com.artisan.startvalidator.config.ArtisanConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@RestController
@RequestMapping("/startVa")
public class ArtisanController {


    @Autowired
    private ArtisanConfigProperties artisanConfigProperties;

    @GetMapping("/getConfigCode")
    public String test() {
        return artisanConfigProperties.getCode();
    }
}
    