package com.Ecredit.demo.PieceJointe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PieceJointeRepo extends JpaRepository<PieceJointe,Long> {
    List<PieceJointe> findByTypeCredit_Id(long id);
}
