package com.example.android.teleprompter.network;

import com.example.android.teleprompter.model.DocumentResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface UsersService {

    @GET
    Observable<DocumentResponse> fetchUsers(@Url String url);
}
