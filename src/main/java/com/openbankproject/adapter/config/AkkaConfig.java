package com.openbankproject.adapter.config;

import akka.actor.ActorSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AkkaConfig {

    public static final String SYSTEM_NAME = "adapter-akka";

    @Bean()
    public ActorSystem actorSystem() {
        return ActorSystem.create(SYSTEM_NAME);
    }

    @Bean
    public AdapterCreator actorCreator(ActorSystem actorSystem, ApplicationContext applicationContext) {
        return new AdapterCreator(actorSystem, applicationContext);
    }
}
