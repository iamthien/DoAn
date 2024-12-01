package com.example.doan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class streetlistActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private ArrayList<streetlist> streetType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_dectection);

        this.recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        this.streetType = new ArrayList<streetlist>();
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 1"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 2"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 3"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 4"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 5"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 6"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 7"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 8"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 9"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 10"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 11"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 12"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 13"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 14"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 15"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 16"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 17"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 18"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 19"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 20"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 21"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 22"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 23"));
        this.streetType.add(new streetlist(R.drawable.flag_street, "Street Name 24"));
        this.recyclerview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        this.recyclerview.setLayoutManager(layoutManager);
        this.recyclerview.setAdapter(new streetlistAdapter(streetlistActivity.this, this.streetType));
    }
}