package com.example.simpleapicall;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    TextView tv_title,tv_description;
    CardView newsCard;
    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_description = itemView.findViewById(R.id.tv_description);
        newsCard = itemView.findViewById(R.id.newsCard);
    }
}
