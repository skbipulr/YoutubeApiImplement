package com.etl.youtubeapiimplement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.etl.youtubeapiimplement.model.Datum;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHolder> {
    private Context context;
    private List<Datum> videoList;

    public YoutubeAdapter(Context context, List<Datum> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vedio_item_layout,
                        parent,false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, final int position) {


        final Datum datum = videoList.get(position);
        holder.webView.loadUrl(datum.getLink());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goIntent = new Intent(context, ShowVideoActivity.class);
                goIntent.putExtra("link",datum.getLink());
                 context.startActivity(goIntent);
                Toast.makeText(context, "Bipul"+position, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


    public class YoutubeViewHolder extends RecyclerView.ViewHolder {

        WebView webView;
        Button button;

        public YoutubeViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.video_view);
            button = itemView.findViewById(R.id.fullScreen);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);

        }


    }
}
