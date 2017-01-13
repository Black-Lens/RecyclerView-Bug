package com.blacklenspub.recyclerviewbug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        people = new ArrayList<>();
        people.add(new Person("Alice", 21));
        people.add(new Person("Bob", 22));
        people.add(new Person("Charlie", 23));
        people.add(new Person("Dana", 24));
        people.add(new Person("Eve", 25));
        people.add(new Person("Felix", 26));
        people.add(new Person("George", 27));
        people.add(new Person("Harry", 28));
        people.add(new Person("Idina", 29));
        people.add(new Person("Jake", 30));
        people.add(new Person("Kathy", 31));
        people.add(new Person("Lora", 32));
        people.add(new Person("Mandy", 33));
        people.add(new Person("Nate", 34));
        people.add(new Person("Oprah", 35));
        people.add(new Person("Peter", 36));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PersonAdapter(people));
    }
}
