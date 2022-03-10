package com.example.fitnesys2.data.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.Collection;

public interface BaseDao<Entity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Entity input);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(Entity input);

    @Delete
    int delete(Entity input);

    Collection<Entity> getAll();

}
