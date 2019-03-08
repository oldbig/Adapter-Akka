package com.openbankproject.adapter.entity

import java.util.Date

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "mappedtransaction", schema = "public")
class Transaction {

  @Column(length = 255, name="bank")
  @BeanProperty
  var bank :String = _

  @Column(length = 64, name="account")
  @BeanProperty
  var account :String = _

  @Column(length = 255, name="transactionid")
  @BeanProperty
  var transactionId :String = _

  @Column(length = 36, name="transactionuuid")
  @BeanProperty
  var transactionUUID :String = _

  @Column(length = 100, name="transactiontype")
  @BeanProperty
  var transactionType :String = _

  @Column(name="amount")
  @BeanProperty
  var amount :Long = _

  @Column(name="newaccountbalance")
  @BeanProperty
  var newAccountBalance :Long = _

  @Column(length = 10, name="currency")
  @BeanProperty
  var currency :String = _

  @Column(name="tstartdate")
  @BeanProperty
  var tStartDate :Date = _

  @Column(name="tfinishdate")
  @BeanProperty
  var tFinishDate :Date = _

  @Column(length = 2000, name="description")
  @BeanProperty
  var description :String = _

  @Column(length = 32, name="chargepolicy")
  @BeanProperty
  var chargePolicy :String = _

  @Column(length = 255, name="counterpartyaccountholder")
  @BeanProperty
  var counterpartyAccountHolder :String = _

  @Column(length = 40, name="counterpartyaccountkind")
  @BeanProperty
  var counterpartyAccountKind :String = _

  @Column(length = 100, name="counterpartybankname")
  @BeanProperty
  var counterpartyBankName :String = _

  @Column(length = 40, name="counterpartynationalid")
  @BeanProperty
  var counterpartyNationalId :String = _

  @deprecated("use CPOtherAccountRoutingAddress instead. ","06/12/2017")
  @Column(length = 128, name="counterpartyaccountnumber")
  @BeanProperty
  var counterpartyAccountNumber :String = _

  //this should eventually be calculated using counterpartyNationalId
  @deprecated("use CPOtherAccountSecondaryRoutingAddress instead. ","06/12/2017")
  @Column(length = 100, name="counterpartyiban")
  @BeanProperty
  var counterpartyIban :String = _

  @Column(length = 44, name="cpcounterpartyid")
  @BeanProperty
  var CPCounterPartyId :String = _

  @Column(length = 36, name="cpotheraccountprovider")
  @BeanProperty
  var CPOtherAccountProvider :String = _

  @Column(length = 255, name="cpotheraccountroutingscheme")
  @BeanProperty
  var CPOtherAccountRoutingScheme :String = _

  @Column(length = 255, name="cpotheraccountroutingaddress")
  @BeanProperty
  var CPOtherAccountRoutingAddress :String = _

  @Column(length = 255, name="cpotheraccountsecondaryroutingscheme")
  @BeanProperty
  var CPOtherAccountSecondaryRoutingScheme :String = _

  @Column(length = 255, name="cpotheraccountsecondaryroutingaddress")
  @BeanProperty
  var CPOtherAccountSecondaryRoutingAddress :String = _

  @Column(length = 255, name="cpotherbankroutingscheme")
  @BeanProperty
  var CPOtherBankRoutingScheme :String = _

  @Column(length = 255, name="cpotherbankroutingaddress")
  @BeanProperty
  var CPOtherBankRoutingAddress :String = _

  @deprecated
  @Column(length = 2000, name="extrainfo")
  @BeanProperty
  var extraInfo :String = _

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mappedtransaction_id_seq")
  @Column(length=20)
  @BeanProperty
  var id :Long = _
}
