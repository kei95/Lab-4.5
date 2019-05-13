package com.example.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mWordListAdapter;
    private WordList mWordList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar == null){
            throw new Error("Can't find brah brah brah");
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mWordList = new WordList();

        mWordListAdapter = new WordListAdapter(this, mWordList);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setAdapter(mWordListAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                mWordList.addWord("+ word " + wordListSize);
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.reset){
            mWordList.reset();
            mWordList = new WordList();

            mWordListAdapter = new WordListAdapter(this, mWordList);

            mRecyclerView = findViewById(R.id.recyclerView);

            mRecyclerView.setAdapter(mWordListAdapter);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
