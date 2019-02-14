package com.openbankproject.adapter

import com.openbankproject.adapter.config.AdapterProps
import javax.annotation.Resource
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class HelloController {

  @Resource
  val props :AdapterProps = null

  @RequestMapping(Array("/hello"))
  def hello(): Any = {

    "hello world"
  }
}
