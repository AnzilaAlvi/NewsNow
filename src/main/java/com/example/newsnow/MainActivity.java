package com.example.newsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getNews();
    }

    void getNews(){
        NewsApiClient newsApiClient = new NewsApiClient("30ce30fa852d4afd9d65f79cbff4f70d");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        response.getArticles().forEach((article)->{
                            Log.i("Article",article.getTitle());
                        });
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.i("GOT Failure", throwable.getMessage());

                    }
                }
        );

    }


}