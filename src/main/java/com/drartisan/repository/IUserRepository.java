package com.drartisan.repository;

import com.drartisan.entity.User;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by summer on 2017/4/17.
 */
public interface IUserRepository extends Repository<User,Integer> {

    User findById(int id);
    User findByUserName(String username);
    List<User> findByState(String state);
}
