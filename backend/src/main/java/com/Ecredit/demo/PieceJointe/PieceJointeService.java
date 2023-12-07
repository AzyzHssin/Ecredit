package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import com.Ecredit.demo.TypeCredit.TypeCredit;
import com.Ecredit.demo.TypeCredit.TypeCreditRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PieceJointeService {
private final PieceJointeRepo pieceJointeRepo;
private final TypeCreditRepo typeCreditRepo;

public List<PieceJointe> getAllPieceJointe(){
    return pieceJointeRepo.findAll();
}
public Optional<PieceJointe> getPieceJointeById(long id ) {
    return pieceJointeRepo.findById(id);
}

    public PieceJointe createPieceJointe(PieceJointe pieceJointe) {
        TypeCredit typeCredit=typeCreditRepo.findById(pieceJointe.getTypeCredit().getId()).orElse(null);
        assert typeCredit!=null;
        typeCredit.getPiecesJointes().add(pieceJointe);
        pieceJointeRepo.save(pieceJointe);
        typeCreditRepo.save(typeCredit);

    return pieceJointe;
    }
    public void deletePieceJointe(Long id) {
        pieceJointeRepo.deleteById(id);
    }
}
