package com.kg.kettik.network;

import com.kg.kettik.models.ToursDetailModel;
import com.kg.kettik.models.ToursModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("tours")
    Call<List<ToursModel>> getTours();

    @GET("tours/{id}")
    Call<ToursDetailModel> getToursById(
            @Path("id") int id );

}
