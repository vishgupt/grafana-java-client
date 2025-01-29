package com.rainier.grafana.client;

import com.rainier.grafana.models.AlertRule;
import com.rainier.grafana.models.RuleGroup;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GrafanaClient {

  interface AlertRulesApi {

    @DELETE("/api/v1/provisioning/alert-rules/{uid}")
    Call<Void> deleteAlertRule(@Path("uid") String uid);

    @GET("/api/v1/provisioning/alert-rules/{uid}")
    Call<AlertRule> getAlertRule(@Path("uid") String uid);

    @POST("/api/v1/provisioning/alert-rules")
    Call<AlertRule> createAlertRule(@Body AlertRule alertRule);

    @PUT("/api/v1/provisioning/alert-rules/{uid}")
    Call<AlertRule> updateAlertRule(@Path("uid") String uid, @Body AlertRule alertRule);

    @GET("/api/v1/provisioning/alert-rules/{uid}/export")
    Call<String> exportAlertRule(@Path("uid") String uid);

    @GET("/api/v1/provisioning/folder/{folderUid}/rule-groups/{group}")
    Call<RuleGroup> getRuleGroup(@Path("folderUid") String folderUid, @Path("group") String group);

    @PUT("/api/v1/provisioning/folder/{folderUid}/rule-groups/{group}")
    Call<RuleGroup> updateRuleGroup(@Path("folderUid") String folderUid, @Path("group") String group,
        @Body RuleGroup ruleGroup);

    @GET("/api/v1/provisioning/folder/{folderUid}/rule-groups/{group}/export")
    Call<String> exportRuleGroup(@Path("folderUid") String folderUid, @Path("group") String group);

    @GET("/api/v1/provisioning/alert-rules")
    Call<List<AlertRule>> getAllAlertRules();

    @GET("/api/v1/provisioning/alert-rules/export")
    Call<String> exportAllAlertRules();
  }

}
