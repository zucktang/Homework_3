package com.example.homework_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework_3.model.WordItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        RecyclerView rv = findViewById(R.id.word_lis_recycler_view);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    WordItem[] item = {
            new WordItem(R.drawable.p1,"Captain","Monkey D Luffy"),
            new WordItem(R.drawable.p2,"Vice Captain","Roronoa Zoro"),
            new WordItem(R.drawable.p3,"Sailor","Nami"),
            new WordItem(R.drawable.p4,"Sniper","Usopp"),
            new WordItem(R.drawable.p5,"chef","Sanji"),
            new WordItem(R.drawable.p6,"Doctor","Tony Tony Chopper"),
            new WordItem(R.drawable.p7,"Archaeologist","Nico Robin"),
            new WordItem(R.drawable.p8,"Ship mechanic","Franky "),
            new WordItem(R.drawable.p9,"Musician","Brook"),
            new WordItem(R.drawable.p10,"Shipwreck","Jimbei")
    };
    public MyAdapter() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(item[position].imageResId);
        holder.wordTextView.setText(item[position].word);
        holder.wordTextView2.setText(item[position].word2);
    }

    @Override
    public int getItemCount() {
        return item.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView wordTextView;
        TextView wordTextView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            wordTextView2 = itemView.findViewById(R.id.word_text_view2);
        }
    }
}