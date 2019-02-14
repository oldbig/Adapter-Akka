package com.openbankproject.adapter;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.util.Timeout;
import com.openbankproject.adapter.actors.CountingActor;
import com.openbankproject.adapter.config.AdapterCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AkkaAdapterApplicationTests {

	@Resource
	private ActorSystem actorSystem;

	@Resource
	private AdapterCreator actorCreator;

	@Test
	public void contextLoads() throws Exception {
		// Create the "actor-in-a-box"
		final Inbox inbox = Inbox.create(actorSystem);
		ActorRef counter = actorCreator.getActorRef(CountingActor.class);

		// tell it to count three times
		inbox.send(counter, "increase");
		inbox.send(counter, "increase");
		inbox.send(counter, "increase");

//		// print the result
//		FiniteDuration duration = FiniteDuration.create(3, TimeUnit.SECONDS);
//		Future<Object> result = inbox.ask(counter, "get", Timeout.durationToTimeout(duration));
//		try {
//			System.out.println("Got back " + Await.result(result, duration));
//		} catch (Exception e) {
//			System.err.println("Failed getting result: " + e.getMessage());
//			throw e;
//		}
	}

}

