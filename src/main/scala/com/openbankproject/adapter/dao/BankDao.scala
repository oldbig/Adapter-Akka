package com.openbankproject.adapter.dao

import java.util

import com.openbankproject.adapter.entity.Bank
import org.springframework.data.jpa.repository.JpaRepository

trait BankDao extends JpaRepository[Bank,Long] {
  def findByShortBankName(shortBankName: String): util.List[Bank]
}
