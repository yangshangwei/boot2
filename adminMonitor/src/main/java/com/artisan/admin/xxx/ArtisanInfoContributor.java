package com.artisan.admin.xxx;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/30 17:30
 * @mark: show me the code , change the world
 */

@Component
public class ArtisanInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("build", Collections.singletonMap("timestamp", new Date()));
    }
}
    