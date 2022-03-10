package com.example.fitnesys2.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.fitnesys2.data.entities.Loop;

import java.util.List;

@Dao
public interface LoopDao extends BaseDao<Loop> {

    @Override
    @Query("SELECT * FROM loops")
    List<Loop> getAll();

    @Query("SELECT * FROM loops WHERE exercise_id = :exerciseId AND workout_id > 0 ")
    List<Loop> selectByExercise(int exerciseId);

    @Query("SELECT * FROM loops WHERE workout_id = :workoutId")
    List<Loop> selectByWorkout(int workoutId);

    @Query("SELECT * FROM loops WHERE id = :id")
    Loop selectByID(int id);


    @Query("SELECT * FROM loops")
    LiveData<List<Loop>> l_getAll();

    @Query("SELECT MAX(id) FROM loops")
    int maxId();

    @Query("SELECT * FROM loops WHERE id = " +
            "(SELECT MIN(id) FROM loops WHERE exercise_id = :exerciseId)")
    Loop rootLoopOfExercise(int exerciseId);

    @Query("SELECT MAX(cnt) FROM " +
            "(SELECT COUNT(*) AS cnt FROM loops WHERE exercise_id =:exerciseId GROUP BY workout_id)")
    int maxCountReps(int exerciseId);

    @Query("DELETE FROM loops")
    void dellAll();

    @Query("SELECT COUNT (*) FROM loops WHERE workout_id = :workoutId")
    int getCountLoopsIn(int workoutId);

    @Query("SELECT COUNT (*) FROM loops WHERE workout_id = :workoutId AND exercise_id =:exerciseId")
    int getCountLoopsInOf(int workoutId, int exerciseId);

    @Query("SELECT COUNT (*) FROM loops WHERE workout_id = :workoutId ORDER BY id")
    List<Integer> getListCountLoopsInOf(int workoutId);

    @Query("SELECT * FROM loops WHERE workout_id = :workoutId AND id = (SELECT MAX(id) FROM loops WHERE exercise_id = :exerciseId)")
    Loop getPrevLoopFromThisWorkout(int workoutId, int exerciseId);

    @Query("SELECT * FROM loops WHERE workout_id = " +
            "(SELECT MAX(workout_id) FROM loops INNER JOIN workouts ON workouts.id = workout_id WHERE loops.exercise_id = :exerciseId AND workouts.is_over=:isOver ) " +
            "AND exercise_id = :exerciseId ")
    List<Loop> getLastWorkoutsWithLoopsOf(int exerciseId, boolean isOver);

    @Query("SELECT * FROM loops WHERE workout_id = " +
            "(SELECT MAX(workout_id) FROM loops WHERE exercise_id = :exerciseId)")
    List<Loop> getLoopsOfPrevWorkout(int exerciseId);

    @Query("DELETE FROM loops WHERE id>0 AND exercise_id=:exerciseId")
    void dellAllAnother(int exerciseId);

    @Query("SELECT COUNT (DISTINCT workout_id) FROM loops WHERE exercise_id = :exerciseId")
    int getCountWorksWithThisExercise(int exerciseId);

    @Query("SELECT MAX(workout_id) FROM loops WHERE exercise_id = :exerciseId")
    int getIdOfPrevWorkout(int exerciseId);
}
