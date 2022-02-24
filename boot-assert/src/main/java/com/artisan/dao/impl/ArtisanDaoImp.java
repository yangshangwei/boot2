package com.artisan.dao.impl;

import com.artisan.dao.ArtisanDao;
import com.artisan.entity.Artisan;
import org.springframework.stereotype.Repository;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
@Repository
public class ArtisanDaoImp implements ArtisanDao {

    @Override
    public Artisan selectArtisan(String artisanId) {
        return new Artisan(artisanId, "testCode", "artisan", "111111111", "11111111@qq.com", "F");
    }


    @Override
    public Artisan selectArtisanReturnNull(String artisanId) {
        return null;
    }
}
    