package com.openbankproject.adapter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApplicationMain

object ApplicationMain extends App{
  SpringApplication.run(classOf[ApplicationMain], args:_*)
}
