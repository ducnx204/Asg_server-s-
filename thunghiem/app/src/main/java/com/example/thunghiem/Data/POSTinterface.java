package com.example.thunghiem.Data;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface POSTinterface {

    @FormUrlEncoded
    @POST("add-product")
    Call<SVResponseProductsPOST> postDATA(@Field("name") String name,
                                          @Field("price1") String price1,
                                          @Field("description") String description);
}
