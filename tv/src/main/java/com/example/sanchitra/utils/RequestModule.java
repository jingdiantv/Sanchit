package com.example.sanchitra.utils;

import com.example.sanchitra.api.Title;
import com.example.sanchitra.api.WatchRequest;
import com.example.sanchitra.model.AnimeContentListModel;
import com.example.sanchitra.model.CommonDataModel;
import com.example.sanchitra.model.DramaContentListModel;
import com.example.sanchitra.model.EpisodeListModel;
import com.example.sanchitra.model.EpisodeVideoModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestModule {

//    for Dramas
    @GET("sanchitra")
    Call<DramaContentListModel> getDramaContentList(@Header("x-api-key") String apikey);

    @POST("episodes")
    Call<EpisodeListModel> getEpisodeList(@Header("x-api-key") String apikey,
                                               @Body Title body);

//    For Anime
    @GET("sanchitra")
    Call<AnimeContentListModel> getAnimeContentList(@Header("x-api-key") String apikey);

//    Common
    @POST("watch_link")
    Call<EpisodeVideoModel> getEpisodeVideo(@Header("x-api-key") String apikey, @Body WatchRequest body);

    @GET("search/")
    Call<CommonDataModel> getSearchResults(@Header("x-api-key") String apikey, @Query("name") String query);

}

