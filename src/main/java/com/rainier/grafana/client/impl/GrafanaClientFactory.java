package com.rainier.grafana.client.impl;

import com.rainier.grafana.client.ClientConfig;
import com.rainier.grafana.client.GrafanaClient;

public class GrafanaClientFactory implements GrafanaClient {

  private ClientConfig clientConfig;

  public GrafanaClientFactory(ClientConfig clientConfig) {
    this.clientConfig = clientConfig;
  }

  public GrafanaClient getGrafanaClient() {
    return RetrofitClient.getGrafanaClient(clientConfig.baseUrl());
  }
}
