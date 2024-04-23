package com.example.ibs.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class MyHealthCheck implements HealthCheck{

    @ConfigProperty(name="quarkus.application.name")
    String applicationName;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up(applicationName);
    }
    
}