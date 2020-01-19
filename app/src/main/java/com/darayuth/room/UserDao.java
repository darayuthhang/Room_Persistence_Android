package com.darayuth.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getUserList();

    @Insert
    void insert(User user);

}
