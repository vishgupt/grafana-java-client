package com.rainier.grafana.models;

import java.util.List;
import java.util.Map;

public record AlertRule(String title, String ruleGroup, String folderUID, String noDataState, String execErrState,
                        String forDuration, int orgId, String uid, String condition, Map<String, String> annotations,
                        Map<String, String> labels, List<Data> data) {


  public record Data(String refId, String queryType, RelativeTimeRange relativeTimeRange, String datasourceUid,
                     Model model) {

  }

  public record RelativeTimeRange(int from, int to) {

  }

  public record Model(String expr, boolean hide, int intervalMs, int maxDataPoints, String refId, String type,
                      List<Condition> conditions, Datasource datasource) {

  }

  public record Condition(Evaluator evaluator, Operator operator, Query query, Reducer reducer, String type) {

  }

  public record Evaluator(List<Integer> params, String type) {

  }

  public record Operator(String type) {

  }

  public record Query(List<String> params) {

  }

  public record Reducer(List<Integer> params, String type) {

  }

}

