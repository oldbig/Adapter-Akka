package com.openbankproject.adapter.endpoint

import com.openbankproject.adapter.service.BankAccountService
import io.swagger.annotations.Api
import javax.annotation.Resource
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("v1/bank"))
@Api(tags = Array("account operation."))
class AccountEndpoint {
  @Resource
  val accountService: BankAccountService = null

  @GetMapping(Array("/bank/{BANK_ID}/account"))
  def getBankFromRemote(@PathVariable("BANK_ID") bankId: String) = this.accountService.getAccounts(s"hello-${bankId}")



}
