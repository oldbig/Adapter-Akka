package com.openbankproject.adapter.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.openbankproject.adapter.actor.SouthSideActor;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Configuration
public class AkkaConfig {
    private static final Logger logger = LoggerFactory.getLogger(AkkaConfig.class);

    public static final String SYSTEM_NAME = "SouthSideAkkaConnector_";
    

    @Bean()
    public ActorSystem actorSystem() {
        Config loadConfig = ConfigFactory.load();
        String hostname = loadConfig.getString("akka.remote.netty.tcp.hostname");
        return ActorSystem.create(SYSTEM_NAME + hostname.replace('.', '-'), loadConfig);
    }

    @PreDestroy
    private void preDestroy() throws TimeoutException, InterruptedException {
        ActorSystem actorSystem = this.actorSystem();
        logger.info("start terminate actorSystem");
        Await.ready(actorSystem.terminate(), Duration.apply(1, TimeUnit.MINUTES));
        logger.info("finished terminate actorSystem");
    }

    @Bean
    public ActorRef sourthSideActorRef(ActorCreator adapterCreator) {
        return adapterCreator.getActorRef(SouthSideActor.class, "akka-connector-actor");
    }
}
