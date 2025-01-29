package com.rainier.grafana.models;

import java.util.List;

public record RuleGroup(String name, List<AlertRule> rules) {}
