package com.lucky.max.reciclertutorial;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder { //класс для получения ссылки на определённый
        //пункт из списка

        public TextView mTextView;

        public ViewHolder(View v){
            super(v);
            mTextView = v.findViewById(R.id.tv_recycler_item); //сколько будет в одном пункте списка данных
            }
    }

    //конструктор
    public RecyclerAdapter(String[] dataset) {
        mDataset = dataset;
    }



    @Override //создаёт новое views и вызывается layout менеджером
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);

        // тут можно менять атрибуты layout (size, margin, paddings)

        ViewHolder vh = new ViewHolder(v);


        return vh;
    }


    //заменяет контент отдельного View(вызывается layout мэнэджером)
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    //озвращает размер данных (вызывается layout мменеджером)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
    //Если отдельный пункт списка имеет несколько составных элементов
    //не только TextView, то нужно нужно добавить инициализацию этих элементов во внутренний класс
    //ViewHolder. Контент каждого списка мы сеттим в методе onBindViewHolder().
}
