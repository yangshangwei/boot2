package com.artisan.repository;

import com.artisan.bean.Artisan;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ArtisanDao extends CrudRepository<Artisan, Integer> {

    boolean existsByUserName(String name);

    boolean existsByNameOrEmailOrPhone(String userName, String email, String telPhone);

    Collection<Artisan> findByNameOrEmailOrPhone(String userName, String email, String phone);
}