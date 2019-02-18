package com.openbankproject.adapter;

import akka.actor.*;
import com.openbankproject.adapter.actor.ResultActor;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

public class DemoTest {
    @Test
    public void client() throws InterruptedException {

        ActorSystem actorSystem = ActorSystem.create("akka_client", ConfigFactory.load("application-test.conf"));

        ActorRef client = actorSystem.actorOf(Props.create(ResultActor.class), "client");
        ActorSelection actorSelection = actorSystem.actorSelection("akka.tcp://SouthSideAkkaConnector_127-0-0-1@127.0.0.1:2662/user/akka-connector-actor");
        actorSelection.tell("increase", client);
        actorSelection.tell("get", client);
        actorSelection.tell(1, client);
        Thread.sleep(10000);
    }
}
