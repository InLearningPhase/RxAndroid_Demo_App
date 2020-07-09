package com.example.rxandroid_demo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);

        Observable.just("How are you").subscribe(s -> txtHi.setText(s));

        Observable.just("abc", "qwe" , "eee").subscribe(s -> rvCustomAdapter.addStringToList(s));

    }
}