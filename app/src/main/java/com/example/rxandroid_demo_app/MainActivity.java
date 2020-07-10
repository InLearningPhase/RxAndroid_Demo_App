package com.example.rxandroid_demo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

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

      //  Observable.just("abc", "qwe" , "eee").subscribe(s -> rvCustomAdapter.addStringToList(s));

        Entry entry1 = new Entry("PS5", BigDecimal.valueOf(1500), new Date());
        Entry entry2 = new Entry("PS4", BigDecimal.valueOf(2500), new Date());
        Entry entry3 = new Entry("PS3", BigDecimal.valueOf(1200), new Date());
        Entry entry4 = new Entry("PS2", BigDecimal.valueOf(1000), new Date());
        Entry entry5 = new Entry("PS1", BigDecimal.valueOf(900), new Date());
        Entry entry6 = new Entry("Xbox1", BigDecimal.valueOf(1700), new Date());
        Entry entry7 = new Entry("Xbox2", BigDecimal.valueOf(2100), new Date());

        Observable.just(entry1,entry2,entry3,entry4,entry5,entry6,entry7).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {

                rvCustomAdapter.addStringToList(entry);

            }
        });

    }
}