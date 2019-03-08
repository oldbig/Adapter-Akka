package com.openbankproject.adapter.service

import com.openbankproject.adapter.entity.BankAccount
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.{GetMapping, PathVariable}

import scala.beans.BeanProperty
import scala.tools.nsc.interpreter.JList

@FeignClient(name="account", url="${adapter.remote.base.url}")
trait BankAccountService {

  @GetMapping(Array("/banks/{BANK_ID}/accounts"))
  def getAccounts(@PathVariable("BANK_ID") bankId :String): AccountResult
}

class AccountResult {
  @BeanProperty
  var accounts: JList[BankAccount] = _
}