package com.example.todolistprework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import org.apache.commons.io.FileUtils;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> tasks;

    Button addButton;
    EditText txtItem;
    RecyclerView taskList;
    TasksAdapter tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addButton);
        txtItem = findViewById(R.id.txtItem);
        taskList = findViewById(R.id.taskList);

        loadTasks();

        TasksAdapter.OnLongClickListener onLongClickListener = new TasksAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                tasks.remove(position);
                tasksAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Task removed!", Toast.LENGTH_SHORT).show();
                saveTasks();
            }
        };
        tasksAdapter = new TasksAdapter(tasks, onLongClickListener);
        taskList.setAdapter(tasksAdapter);
        taskList.setLayoutManager(new LinearLayoutManager(this));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoTask = txtItem.getText().toString();
                tasks.add(todoTask);    // Adds item to the model
                tasksAdapter.notifyItemInserted(tasks.size() - 1);  // Notifies the adapter that an item has been added
                txtItem.setText("");
                Toast.makeText(getApplicationContext(), "Task added!", Toast.LENGTH_SHORT).show();
                saveTasks();
            }
        });

    }

    private File getDataFile() {
        return new File(getFilesDir(), "data.txt");
    }

    private void loadTasks() {      // Loads items by reading every line of data.txt
        try {
            tasks = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading tasks");
            tasks = new ArrayList<>();
        }
    }

    private void saveTasks() {
        try {
            FileUtils.writeLines(getDataFile(), tasks);
        } catch (IOException e) {
            Log.e("MainActivity", "Error writing tasks");
        }
    }
}