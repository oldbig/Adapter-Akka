package com.openbankproject.adapter.dao

import com.openbankproject.adapter.entity.BankAccount
import org.springframework.data.jpa.repository.JpaRepository

trait BankAccountDao extends JpaRepository[BankAccount, Long] {

}
