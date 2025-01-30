package com.rainier.grafana.models;

import java.util.List;

public record TemplateGroup(String name, String description, List<String> templates) {}

