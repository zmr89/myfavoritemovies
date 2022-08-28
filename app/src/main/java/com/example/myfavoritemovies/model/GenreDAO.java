package com.example.myfavoritemovies.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GenreDAO {

    @Insert
    void insert(Genre genre);

    @Update
    void update(Genre genre);

    @Delete
    void delete(Genre genre);

    @Query("SELECT * FROM genres_table")
    LiveData<List<Genre>> getAllGenres();
}
