package com.openbankproject.adapter;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class DemoTest {
    @Test
    public void client() {
        Config config = ConfigFactory.load("application-test");
        ActorSystem actorSystem = ActorSystem.create("akka_client", config);

        ActorSelection actorSelection = actorSystem.actorSelection("akka.tcp://adapter-akka@127.0.0.1:2552/user/countingActor");
        actorSelection.tell("increase", ActorRef.noSender());
        actorSelection.tell("get", ActorRef.noSender());
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        Future<Object> get = Patterns.ask(actorSelection, "get", timeout);
        System.out.println(get);
    }
}
