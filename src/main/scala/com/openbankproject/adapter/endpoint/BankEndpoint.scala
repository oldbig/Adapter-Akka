package com.openbankproject.adapter.endpoint

import com.openbankproject.adapter.dao.BankDao
import com.openbankproject.adapter.entity.Bank
import io.swagger.annotations.Api
import javax.annotation.Resource
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("v1/bank"))
@Api(tags = Array("banks operation."))
class BankEndpoint {

  @Resource
  val bankDao: BankDao = null

  @GetMapping
  def getAll = this.bankDao.findAll()

  @GetMapping(Array("/{id}"))
  def getById(@PathVariable("id") id :Long) = this.bankDao.findById(id)

  @PostMapping()
  def createBank(bank :Bank) = this.bankDao.save(bank)

  @PutMapping(Array("/{id}"))
  def updateBank(@PathVariable("id") id :Long, bank :Bank) = this.bankDao.save(bank)

  @DeleteMapping(Array("/{id}"))
  def deleteBank(@PathVariable("id") id :Long) = this.bankDao.deleteById(id)


  //@GetMapping(Array("/shortBankName/{shortBankName}"))
  //def getByShortBankName(@PathVariable("shortBankName") shortBankName: String): java.util.List[Bank] = this.bankDao.findByShortBankName(shortBankName)

}
