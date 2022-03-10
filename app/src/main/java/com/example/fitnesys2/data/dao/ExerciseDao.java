package com.example.fitnesys2.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.fitnesys2.data.entities.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao extends BaseDao<Exercise> {

    @Override
    @Query("SELECT * FROM exercises")
    List<Exercise> getAll();

    @Query("DELETE FROM exercises WHERE id =:targetId")
    int delById(int targetId);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> l_getAll();

    @Query("SELECT name FROM  exercises WHERE id != 0 ORDER BY id")
    List<String> getAllNames();

    @Query("SELECT name FROM  exercises WHERE id != 0 ORDER BY id")
    LiveData<List<String>> l_getAllNames();

    @Query("SELECT MAX(id) FROM exercises")
    int maxId();

    @Query("DELETE FROM exercises")
    void dellAll();

    @Query("SELECT id FROM exercises WHERE name = :targetName")
    int checkName(String targetName);

    @Query("SELECT * FROM exercises WHERE id = :id")
    Exercise selectByID(int id);

    @Query("SELECT COUNT(*)  FROM exercises")
    int getCount();
}
