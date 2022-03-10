package com.example.fitnesys2.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;


import com.example.fitnesys2.data.entities.Group;

import java.util.List;

@Dao
public interface GroupDao extends BaseDao<Group> {

    @Override
    @Query("SELECT * FROM groups")
    List<Group> getAll();

    @Query("SELECT * FROM groups")
    LiveData<List<Group>> l_getAll();

    @Query("SELECT MAX(id) FROM groups")
    int maxId();

    @Query("SELECT id FROM groups WHERE name = :targetName")
    int checkName(String targetName);

    @Query("DELETE FROM groups")
    void dellAll();

    @Query("SELECT * FROM groups WHERE id = :id")
    Group selectByID(int id);

}
