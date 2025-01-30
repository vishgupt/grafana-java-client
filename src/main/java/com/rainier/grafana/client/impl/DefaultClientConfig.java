package com.rainier.grafana.client.impl;

import com.rainier.grafana.client.ClientConfig;

public record DefaultClientConfig(String baseUrl, String apiKey) implements ClientConfig {

}
