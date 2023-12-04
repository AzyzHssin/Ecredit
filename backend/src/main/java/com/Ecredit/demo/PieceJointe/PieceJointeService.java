package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PieceJointeService {
private final PieceJointeRepo pieceJointeRepo;

public List<PieceJointe> getAllPieceJointe(){
    return pieceJointeRepo.findAll();
}
public Optional<PieceJointe> getPieceJointeById(long id ) {
    return pieceJointeRepo.findById(id);
}

    public PieceJointe createPieceJointe(PieceJointe pieceJointe) {
        return pieceJointeRepo.save(pieceJointe);
    }
    public void deletePieceJointe(Long id) {
        pieceJointeRepo.deleteById(id);
    }
}
