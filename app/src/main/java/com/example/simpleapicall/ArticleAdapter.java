package com.example.simpleapicall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapicall.Models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder>{
    private Context context;
    private List<Article> articleList;
    private ArticleClickListener listener;

    public ArticleAdapter(Context context, List<Article> articleList, ArticleClickListener listener) {
        this.context = context;
        this.articleList = articleList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(holder.getAdapterPosition());
        holder.tv_title.setText(article.getTitle());
        holder.tv_description.setText(article.getDescription());
        holder.tv_title.setSelected(true);
        holder.tv_description.setSelected(true);
        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, article.getUrl(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
//                context.startActivity(intent);
                listener.onArticleClicked(article.getUrl());
            }
        });
        if((article.getUrlToImage()) != null) {
            Picasso.get()
                    .load(article.getUrlToImage())
                    .placeholder(R.drawable.ic_no_image)
                    .into(holder.img_newsPic);
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
