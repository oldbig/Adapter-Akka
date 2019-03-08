package com.openbankproject.adapter.entity

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonAlias, JsonProperty}
import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "mappedbankaccount", schema = "public")
class BankAccount {

  @JsonProperty("bank_id")
  @Column(length = 44, name="bank")
  @BeanProperty
  var bank :String = _

  @Column(length = 64, name="theaccountid")
  @BeanProperty
  @JsonProperty("id")
  var theAccountId :String = _

  @Column(length = 50, name="accountiban")
  @BeanProperty
  var accountIban :String = _

  @Column(length = 10, name="accountcurrency")
  @BeanProperty
  var accountCurrency :String = _

  @Column(length = 50, name="accountswiftbic")
  @BeanProperty
  var accountSwiftBic :String = _

  @JsonProperty("number")
  @Column(length = 128, name="accountnumber")
  @BeanProperty
  var accountNumber :String = _

  @deprecated
  @Column(length = 100)
  @BeanProperty
  var holder :String = _

  //this is the smallest unit of currency! e.g. cents, yen, pence, øre, etc.
  @Column(name="accountbalance")
  @BeanProperty
  var accountBalance :Long = _

  @Column(length = 255, name="accountname")
  @BeanProperty
  var accountName :String = _

  @Column(length = 255)
  @BeanProperty
  var kind :String = _

  @JsonProperty("label")
  @Column(length = 255, name="accountlabel")
  @BeanProperty
  var accountLabel :String = _

  //the last time this account was updated via hbci
  @Column(length = 255, name="accountlastupdate")
  @BeanProperty
  var accountLastUpdate: Date = _

  @Column(length = 32, name="maccountroutingscheme")
  @BeanProperty
  var accountRoutingScheme :String = _

  @Column(length = 128, name="maccountroutingaddress")
  @BeanProperty
  var accountRoutingAddress :String = _

  @Column(length = 44, name="mbranchid")
  @BeanProperty
  var branchId :String = _

  @Column(length = 10, name="accountrulescheme1")
  @BeanProperty
  var accountRuleScheme1 :String = _

  @Column(name="accountrulevalue1")
  @BeanProperty
  var accountRuleValue1 :Long = _

  @Column(length = 10, name="accountrulescheme2")
  @BeanProperty
  var accountRuleScheme2 :String = _

  @Column(name="accountrulevalue2")
  @BeanProperty
  var accountRuleValue2 :Long = _

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mappedbankaccountdata_id_seq")
  @Column(length=20)
  @JsonProperty("identifier")
  @BeanProperty
  var id :Long = _
}
