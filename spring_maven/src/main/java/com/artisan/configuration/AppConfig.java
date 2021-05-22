package com.artisan.configuration;

import com.artisan.annotation.EnableArtisan;
import com.artisan.impt.ArtisanImportSelector;
import com.artisan.impt.ArtisanRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 系统当前加载的配置类
 */

@Configuration
//@Import({ArtisanConfig.class})

// @Import(ArtisanImportSelector.class)

//@Import(ArtisanRegistrar.class)


@EnableArtisan
public class AppConfig {
}
    