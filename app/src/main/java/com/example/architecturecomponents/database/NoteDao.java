package com.example.architecturecomponents.database;

import android.view.View;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNoteAll(List<NoteEntity> noteEntity);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("SELECT * FROM notes WHERE id = :id")
    NoteEntity getNoteById(int id);

    @Query("SELECT * FROM NOTES ORDER BY date DESC")
    LiveData<List<NoteEntity>> getAll();

    @Query("DELETE FROM notes")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM notes")
    int getCount();

}