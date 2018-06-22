package com.lucky.max.reciclertutorial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[ ] myDataset = getDataSet();

        mRecyclerView = findViewById(R.id.my_recycler_view);

        //Если мы уверены что изменения в контенте не изменят размер  layout,
        //recycle ру передаем параметр true - это увеличит производительность
        mRecyclerView.setHasFixedSize(true);

        //use Lianer Layout
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //create adapter
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
            }

            private String[] getDataSet(){
        String[ ] mDataSet = new String[100];
        for (int i = 0; i < 100; i++){
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
            }
}

// В методе onCreate() мы инициализируем виджет RecyclerView и RecyclerAdapter,
// передаваю последнему массив строковых данных. Данные получаеим из
//метода getDataSet()
