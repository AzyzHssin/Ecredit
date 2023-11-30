package com.Ecredit.demo.PieceJointe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/PieceJointe")
public class PieceJointeController {
    private final PieceJointeService pieceJointeService;

    @GetMapping
    public List<PieceJointe> getAllPieceJointe(){
        return pieceJointeService.getAllPieceJointe();
    }
    @GetMapping("/{id}")
    public Optional<PieceJointe> getPieceJointeById(@PathVariable long id ){
        return pieceJointeService.getPieceJointeById(id);
    }
}
