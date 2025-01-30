package com.rainier.grafana.client.impl;

import com.rainier.grafana.client.ClientConfig;
import com.rainier.grafana.client.GrafanaClient;
import com.rainier.grafana.client.GrafanaClient.AlertRulesApi;
import com.rainier.grafana.client.GrafanaClient.ContactPointApi;
import com.rainier.grafana.client.GrafanaClient.MuteTimingApi;
import com.rainier.grafana.client.GrafanaClient.PolicyTreeApi;
import com.rainier.grafana.client.GrafanaClient.TemplateApi;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

  private static ConcurrentHashMap<ClientConfig, Retrofit> retrofitClientMap = new ConcurrentHashMap<>();

  public static Retrofit getRetrofitInstance(ClientConfig clientConfig) {
    return retrofitClientMap.computeIfAbsent(clientConfig, config -> new Retrofit.Builder()
        .baseUrl(config.baseUrl())
        .client(getOkHttpClient(config.apiKey()))
        .addConverterFactory(GsonConverterFactory.create())
        .build());
  }

  private static OkHttpClient getOkHttpClient(String authToken) {
    return new OkHttpClient.Builder()
        .addInterceptor(new AuthInterceptor(authToken)) // Attach token to requests
        .build();
  }

  public static class AuthInterceptor implements Interceptor {

    private String authToken;

    public AuthInterceptor(String token) {
      this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
      Request original = chain.request();
      Request.Builder builder = original.newBuilder()
          .header("Authorization", "Bearer " + authToken) // Attach token
          .method(original.method(), original.body());

      return chain.proceed(builder.build());
    }
  }
}
