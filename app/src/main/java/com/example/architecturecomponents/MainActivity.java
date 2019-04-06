package com.example.architecturecomponents;

import android.content.Intent;
import android.os.Bundle;

import com.example.architecturecomponents.database.NoteEntity;
import com.example.architecturecomponents.ui.NotesAdapter;
import com.example.architecturecomponents.utilities.SampleData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
private List<NoteEntity> notesData = new ArrayList<>();
NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditorActivity.class);
                startActivity(intent);
            }
        });
        initRecyclerView();
        notesData.addAll(SampleData.getNotes());
        for (NoteEntity note:
             notesData) {
            Log.d("PlainOlNotes", note.toString());
        }
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        notesAdapter = new NotesAdapter(notesData,this);
        recyclerView.setAdapter(notesAdapter);
    }

}
