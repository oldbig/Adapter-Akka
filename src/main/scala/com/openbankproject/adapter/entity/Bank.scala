package com.openbankproject.adapter.entity

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "mappedbank", schema = "public")
class Bank {

  @Column(length = 255)
  @BeanProperty
  var permalink :String = _

  @Column(length = 255, name = "fullbankname")
  @BeanProperty
  var fullBankName :String = _

  @Column(length = 255, name="shortbankname")
  @BeanProperty
  var shortBankName :String = _

  @Column(length = 255, name="logourl")
  @BeanProperty
  var logoURL :String = _

  @Column(length = 255, name="websiteurl")
  @BeanProperty
  var websiteURL :String = _

  @Column(length = 255, name="swiftbic")
  @BeanProperty
  var swiftBIC :String = _

  @Column(length = 255)
  @BeanProperty
  var national_identifier :String = _

  @Column(length = 255, name="mbankroutingscheme")
  @BeanProperty
  var mBankRoutingScheme :String = _

  @Column(length = 255, name="mbankroutingaddress")
  @BeanProperty
  var mBankRoutingAddress :String = _

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mappedbank_id_seq")
  @Column(length=20)
  @BeanProperty
  var id :Long = _
}
