package com.androidnetworking.assandroidnetworking.Server;

public class APiuntil {
    public static final String baseUrl = "http://asian.dotplays.com/";

    public static DataClient getData() {
        return RetrofitClient.getRetrofit(baseUrl).create(DataClient.class);
    }
}
