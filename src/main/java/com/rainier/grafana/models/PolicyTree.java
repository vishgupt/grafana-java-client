package com.rainier.grafana.models;

import java.util.List;

public record PolicyTree(String id, String name, List<String> rules) {}
