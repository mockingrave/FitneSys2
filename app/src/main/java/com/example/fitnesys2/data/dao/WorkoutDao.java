package com.example.fitnesys2.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.fitnesys2.data.entities.Workout;

import java.util.List;

@Dao
public interface WorkoutDao extends BaseDao<Workout> {

    @Override
    @Query("SELECT * FROM workouts")
    List<Workout> getAll();

    @Query("SELECT * FROM workouts")
    LiveData<List<Workout>> l_getAll();

    @Query("SELECT DISTINCT workouts.* FROM workouts INNER JOIN loops ON  loops.workout_id = workouts.id WHERE exercise_id=:exerciseId ORDER BY id DESC ")
    List<Workout> selectByExercise(int exerciseId);

    @Query("SELECT MAX(id) FROM workouts")
    int maxId();

    @Query("SELECT * FROM workouts WHERE id = (SELECT MAX(id) FROM workouts WHERE is_over = :isOver)")
    Workout lastOpenWork(boolean isOver);

    @Query("SELECT COUNT(*)  FROM workouts")
    int getCount();

    @Query("DELETE FROM workouts")
    void dellAll();

    @Query("DELETE FROM workouts WHERE id >0")
    void dellAll1();
}
