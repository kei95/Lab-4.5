package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private WordList mWordList; // data
    private LayoutInflater mLayoutInflater; // we need to inflate our ViewHolder layout
    private Context mContext;

    public WordListAdapter(Context context, WordList wordList){
        // creating an instance of LayoutInflater <- we need context parameter
        // context gives the information about where you're inflating the layout
        this.mWordList = wordList;
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // similar to onCreate() in actibity.
        // we initialize our layout.
        View wordHolder = mLayoutInflater.inflate(R.layout.word_holder, viewGroup, false);

        return new WordViewHolder(wordHolder, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
        // we connect(bind) out data to the viewHolder
        // i -> position of cell
        Word word = mWordList.getWord(i);
        wordViewHolder.bind(word);
    }


    @Override
    public int getItemCount() {
        return mWordList.getmWords().size();
    }

    // That's my view holder -> one cell
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView wordTV;
        private WordListAdapter mWordListAdapter;


        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordTV = itemView.findViewById(R.id.word);
            mWordListAdapter = adapter;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //1. get the position of cell
                    int position = getLayoutPosition();
                    Word word = mWordList.getWord(position);
                    Toast.makeText(mContext, word.getDefinition(), Toast.LENGTH_SHORT).show();

                    return true;
                }
            });
        }

        public void bind(Word word){
            wordTV.setText(word.getWord());
        }
        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            mWordList.set(mPosition, "Clicked!" + mPosition);
            mWordListAdapter.notifyDataSetChanged();
        }
    }
}
