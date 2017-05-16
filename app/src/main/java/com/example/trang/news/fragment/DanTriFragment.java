package com.example.trang.news.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trang.news.activity.DanTriActivity;
import com.example.trang.news.news.NewsModelDanTriApp;
import com.example.trang.news.adapter.NewsDanTriAdapter;
import com.example.trang.news.R;
import com.vaadin.external.jsoup.Jsoup;
import com.vaadin.external.jsoup.nodes.Document;
import com.vaadin.external.jsoup.nodes.Element;
import com.vaadin.external.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Trang on 5/16/2017.
 */

public class DanTriFragment extends Fragment {
    public static final String LINKDANTRI = "linkdantri";
    private View view;
    private NewsDanTriAdapter sportAdapter;
    private RecyclerView recyclerView;
    public static final String capnhatRRS = "http://dantri.com.vn/Home.rss";

    public DanTriFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_dantri, container, false);
        new newsAsyscTask().execute(capnhatRRS);
        return view;
    }

    class newsAsyscTask extends AsyncTask<String, Void, ArrayList<NewsModelDanTriApp>> {

        private ProgressDialog progressDialog;

        @Override
        protected ArrayList<NewsModelDanTriApp> doInBackground(String... params) {
            String url = params[0];
            ArrayList<NewsModelDanTriApp> arrNewsModels = new ArrayList<>();
            try {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.select("item");
                for (Element element : elements) {
                    String title = element.select("title").text();
                    String link = element.select("link").text();
                    String description = element.select("description").text();
                    Document docImg = Jsoup.parse(description);
                    String urlImg = docImg.select("img").get(0).attr("src");
                    arrNewsModels.add(new NewsModelDanTriApp(title, link, urlImg));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return arrNewsModels;
        }

        @Override
        protected void onPostExecute(ArrayList<NewsModelDanTriApp> newsModels) {
            super.onPostExecute(newsModels);
            progressDialog.dismiss();
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_sport);
            sportAdapter = new NewsDanTriAdapter(newsModels, getActivity());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(sportAdapter);
            sportAdapter.setOnClickItemSportListner(new NewsDanTriAdapter.OnClickItemSportListner() {
                @Override
                public void onItemClick(String link) {
                    Intent intent = new Intent(getActivity(), DanTriActivity.class);
                    intent.putExtra(LINKDANTRI, link);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

    }


}
