package com.artisan.dao;

import com.artisan.entity.Artisan;
import org.springframework.stereotype.Repository;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */


public interface ArtisanDao {

    Artisan selectArtisan(String artisanId);

    Artisan selectArtisanReturnNull(String artisanId);
}
    