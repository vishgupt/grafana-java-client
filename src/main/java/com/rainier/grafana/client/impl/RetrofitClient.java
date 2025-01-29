package com.rainier.grafana.client.impl;

import com.rainier.grafana.client.GrafanaClient;
import java.util.concurrent.ConcurrentHashMap;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static ConcurrentHashMap<String, Retrofit> retrofitClientMap = new ConcurrentHashMap<>();

  public static Retrofit getRetrofitInstance(String baseUrl) {
    return retrofitClientMap.computeIfAbsent(baseUrl, url -> new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build());
  }

  // Create API Service
  public static GrafanaClient getGrafanaClient(String baseUrl) {
    return getRetrofitInstance(baseUrl).create(GrafanaClient.class);
  }
}
