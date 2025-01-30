package com.rainier.grafana.client.impl;

import static com.rainier.grafana.client.impl.RetrofitSingleton.getRetrofitInstance;

import com.rainier.grafana.client.ClientConfig;
import com.rainier.grafana.client.GrafanaClient;

public class GrafanaClientFactory {

  private ClientConfig clientConfig;

  public GrafanaClientFactory(ClientConfig clientConfig) {
    this.clientConfig = clientConfig;
  }

  public GrafanaClient getGrafanaClient() {
    return new DefaultGrafanaClient(clientConfig);
  }

  static class DefaultGrafanaClient implements GrafanaClient {

    private AlertRulesApi alertRulesApi;
    private ContactPointApi contactPointApi;
    private PolicyTreeApi policyTreeApi;
    private TemplateApi templateApi;
    private MuteTimingApi muteTimingApi;

    public DefaultGrafanaClient(ClientConfig clientConfig) {
      this.alertRulesApi = getRetrofitInstance(clientConfig).create(GrafanaClient.AlertRulesApi.class);
      this.contactPointApi = getRetrofitInstance(clientConfig).create(GrafanaClient.ContactPointApi.class);
      this.policyTreeApi = getRetrofitInstance(clientConfig).create(GrafanaClient.PolicyTreeApi.class);
      this.templateApi = getRetrofitInstance(clientConfig).create(GrafanaClient.TemplateApi.class);
      this.muteTimingApi = getRetrofitInstance(clientConfig).create(GrafanaClient.MuteTimingApi.class);
    }

    @Override
    public AlertRulesApi alertRulesApi() {
      return alertRulesApi;
    }

    @Override
    public ContactPointApi contactPointApi() {
      return contactPointApi;
    }

    @Override
    public PolicyTreeApi policyTreeApi() {
      return policyTreeApi;
    }

    @Override
    public TemplateApi templateApi() {
      return templateApi;
    }

    @Override
    public MuteTimingApi muteTimingApi() {
      return muteTimingApi;
    }
  }
}
