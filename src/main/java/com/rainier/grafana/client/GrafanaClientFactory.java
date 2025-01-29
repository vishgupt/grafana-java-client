package com.rainier.grafana.client;

public class GrafanaClientFactory implements GrafanaClient {

  private ClientConfiguration clientConfiguration;

  public GrafanaClientFactory(ClientConfiguration clientConfiguration) {
    this.clientConfiguration = clientConfiguration;
  }

  public GrafanaClient getGrafanaClient() {
    return RetrofitClient.getGrafanaClient(clientConfiguration.baseUrl());
  }
}
