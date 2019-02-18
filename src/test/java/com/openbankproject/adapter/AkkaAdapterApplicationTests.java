package com.openbankproject.adapter;

import akka.actor.*;
import com.openbankproject.adapter.actor.ResultActor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AkkaAdapterApplicationTests {

	@Resource
	private ActorSystem actorSystem;

	@Resource
	private ActorRef sourthSideActorRef;

	@Test
	public void contextLoads() throws Exception {
		ActorRef client = actorSystem.actorOf(Props.create(ResultActor.class), "client");
		ActorSelection actorSelection = actorSystem.actorSelection("akka.tcp://SouthSideAkkaConnector_127-0-0-1@127.0.0.1:2662/user/akka-connector-actor");
        actorSelection.tell("increase", client);
        actorSelection.tell("increase", client);
        actorSelection.tell("get", client);

		System.out.println();
	}


}

