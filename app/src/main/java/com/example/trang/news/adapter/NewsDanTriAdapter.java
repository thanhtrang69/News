package com.example.trang.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trang.news.news.NewsModelDanTriApp;
import com.example.trang.news.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Trang on 5/12/2017.
 */

public class NewsDanTriAdapter extends RecyclerView.Adapter<NewsDanTriAdapter.NewsHolder> {
    private ArrayList<NewsModelDanTriApp> arrNewsModel;
    private Context mContext;
    private View view;
    private OnClickItemSportListner onClickItemSportListner;

    public void setOnClickItemSportListner(OnClickItemSportListner onClickItemSportListner) {
        this.onClickItemSportListner = onClickItemSportListner;
    }

    public NewsDanTriAdapter(ArrayList<NewsModelDanTriApp> arrNewsModel, Context mContext) {
        this.arrNewsModel = arrNewsModel;
        this.mContext = mContext;
    }

    @Override
    public NewsDanTriAdapter.NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_dantri, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsDanTriAdapter.NewsHolder holder, int position) {
        NewsModelDanTriApp news = getItem(position);
        holder.tvTitleNews.setText(news.getTitelSport());
        Picasso.with(view.getContext()).load(news.getUrlImageSport()).into(holder.imgNews);

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
            tvTitleNews = (TextView) itemView.findViewById(R.id.tvNews_sport);
            imgNews = (ImageView) itemView.findViewById(R.id.imgNews_sport);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_sport);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemSportListner.onItemClick(arrNewsModel.get(getAdapterPosition()).getLinkSport());
                }
            });
        }
    }


    public NewsModelDanTriApp getItem(int posisson) {
        return arrNewsModel.get(posisson);
    }

    public interface OnClickItemSportListner {
        void onItemClick(String link);
    }
}
