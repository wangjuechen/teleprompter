//package com.example.android.teleprompter.network;
//
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//import com.example.android.teleprompter.utils.Constant.BASE_URL;
//
//
//public class ApiFactory {
//
//    public static UsersService create() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        return retrofit.create(UsersService.class);
//    }
//
//}
