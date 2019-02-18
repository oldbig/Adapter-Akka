package com.openbankproject.adapter.actor

import java.util.Date

import akka.actor.Actor
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("SouthSideActor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SouthSideActor  extends Actor  {
  val mockAdapaterInfo =
    s"""
      |{
      |  "name":"String",
      |  "version":"String",
      |  "git_commit":"String",
      |  "date":"${new Date()}"
      |}
    """.stripMargin

  def receive = {
    case message => sender ! mockAdapaterInfo
  }

}
