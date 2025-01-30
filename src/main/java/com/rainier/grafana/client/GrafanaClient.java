package com.rainier.grafana.client;

import com.rainier.grafana.models.AlertRule;
import com.rainier.grafana.models.ContactPoint;
import com.rainier.grafana.models.MuteTiming;
import com.rainier.grafana.models.PolicyTree;
import com.rainier.grafana.models.RuleGroup;
import com.rainier.grafana.models.TemplateGroup;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GrafanaClient {

  AlertRulesApi alertRulesApi();

  ContactPointApi contactPointApi();

  PolicyTreeApi policyTreeApi();

  TemplateApi templateApi();

  MuteTimingApi muteTimingApi();

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

  interface ContactPointApi {

    // Get all contact points
    @GET("api/v1/provisioning/contact-points")
    Call<List<ContactPoint>> getAllContactPoints();

    // Get exported contact points
    @GET("api/v1/provisioning/contact-points/export")
    Call<String> exportContactPoints();

    // Create a contact point
    @POST("api/v1/provisioning/contact-points")
    Call<ContactPoint> createContactPoint(@Body ContactPoint contactPoint);

    // Update an existing contact point
    @PUT("api/v1/provisioning/contact-points/{uid}")
    Call<ContactPoint> updateContactPoint(@Path("uid") String uid, @Body ContactPoint contactPoint);

    // Delete a contact point
    @DELETE("api/v1/provisioning/contact-points/{uid}")
    Call<Void> deleteContactPoint(@Path("uid") String uid);
  }

  interface PolicyTreeApi {

    // Get the policy tree
    @GET("api/v1/provisioning/policies")
    Call<PolicyTree> getPolicyTree();

    // Export the policy tree
    @GET("api/v1/provisioning/policies/export")
    Call<String> exportPolicyTree();

    // Set the policy tree
    @PUT("api/v1/provisioning/policies")
    Call<PolicyTree> setPolicyTree(@Body PolicyTree policyTree);

    // Reset the policy tree (Clear it)
    @DELETE("api/v1/provisioning/policies")
    Call<Void> resetPolicyTree();
  }

  interface TemplateApi {

    // Get all template groups
    @GET("api/v1/provisioning/templates")
    Call<List<TemplateGroup>> getAllTemplateGroups();

    // Get a specific template group
    @GET("api/v1/provisioning/templates/{name}")
    Call<TemplateGroup> getTemplateGroup(@Path("name") String name);

    // Create or update a template group
    @PUT("api/v1/provisioning/templates/{name}")
    Call<TemplateGroup> createOrUpdateTemplateGroup(@Path("name") String name, @Body TemplateGroup templateGroup);

    // Delete a template group
    @DELETE("api/v1/provisioning/templates/{name}")
    Call<Void> deleteTemplateGroup(@Path("name") String name);
  }

  interface MuteTimingApi {

    // Get all mute timings
    @GET("api/v1/provisioning/mute-timings")
    Call<List<MuteTiming>> getAllMuteTimings();

    // Get a specific mute timing
    @GET("api/v1/provisioning/mute-timings/{name}")
    Call<MuteTiming> getMuteTiming(@Path("name") String name);

    // Create a new mute timing
    @POST("api/v1/provisioning/mute-timings")
    Call<MuteTiming> createMuteTiming(@Body MuteTiming muteTiming);

    // Replace an existing mute timing
    @PUT("api/v1/provisioning/mute-timings/{name}")
    Call<MuteTiming> updateMuteTiming(@Path("name") String name, @Body MuteTiming muteTiming);

    // Delete a mute timing
    @DELETE("api/v1/provisioning/mute-timings/{name}")
    Call<Void> deleteMuteTiming(@Path("name") String name);

    // Export all mute timings
    @GET("api/v1/provisioning/mute-timings/export")
    Call<String> exportAllMuteTimings();

    // Export a specific mute timing
    @GET("api/v1/provisioning/mute-timings/{name}/export")
    Call<String> exportMuteTiming(@Path("name") String name);
  }
}
