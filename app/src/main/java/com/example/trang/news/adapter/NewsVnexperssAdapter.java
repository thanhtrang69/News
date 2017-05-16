package com.example.trang.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trang.news.news.NewsModel;
import com.example.trang.news.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

/**
 * Created by Trang on 5/12/2017.
 */

public class NewsVnexperssAdapter extends RecyclerView.Adapter<NewsVnexperssAdapter.NewsHolder> {
    private ArrayList<NewsModel> arrNewsModel;
    private Context context;
    private View view;
    private OnClickItemVnexperssListner vnexperssListner;

    public void setVnexperssListner(OnClickItemVnexperssListner vnexperssListner) {
        this.vnexperssListner = vnexperssListner;
    }

    public NewsVnexperssAdapter() {
    }

    public NewsVnexperssAdapter(ArrayList<NewsModel> arrNewsModel, Context mContext) {
        this.arrNewsModel = arrNewsModel;
        this.context = mContext;
    }

    @Override
    public NewsVnexperssAdapter.NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsVnexperssAdapter.NewsHolder holder, int position) {
        NewsModel news = getItem(position);
        holder.tvTitleNews.setText(news.getTitel());
            Picasso.with(view.getContext()).load(news.getUrlImage()).into(holder.imgNews);


    }

    @Override
    public int getItemCount() {
        return (arrNewsModel != null) ? arrNewsModel.size() : 0;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private TextView tvTitleNews;
        private ImageView imgNews;
        private LinearLayout linearLayout;

        public NewsHolder(View itemView) {
            super(itemView);
            tvTitleNews = (TextView) itemView.findViewById(R.id.tvNews);
            imgNews = (ImageView) itemView.findViewById(R.id.imgNews);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_item);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vnexperssListner.onItemClick(arrNewsModel.get(getAdapterPosition()).getLink());
                }
            });
        }
    }


    public NewsModel getItem(int posisson) {
        return arrNewsModel.get(posisson);
    }

    public interface OnClickItemVnexperssListner {
        void onItemClick(String link);
    }
}
