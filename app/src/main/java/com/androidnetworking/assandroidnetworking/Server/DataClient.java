package com.androidnetworking.assandroidnetworking.Server;

import com.androidnetworking.assandroidnetworking.model.Post;
import com.androidnetworking.assandroidnetworking.modelCategory.Category;
import com.androidnetworking.assandroidnetworking.modelPosst2.Post2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataClient {
    //http://asian.dotplays.com/wp-json/wp/v2/posts?_embed
    @GET("wp-json/wp/v2/posts?_embed")
    Call<List<Post>> getPostOfhome();

    //    Call<List<Post>> getPostOfCategory(@Query("category") String category_id,
//                                       @Query("per_page") String per_page,
//                                       @Query("paging") String paging);
    @GET("wp-json/wp/v2/categories")
    Call<List<Category>> getCategorys(@Query("page") int page,
                                      @Query("per_page") int per_page);

    @GET("wp-json/wp/v2/posts/{id}")
    Call<Post2> getposst(@Path("id") int id);
}
