package com.openbankproject.adapter.dao

import com.openbankproject.adapter.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

trait TransactionDao extends JpaRepository[Transaction, Long] {

}
