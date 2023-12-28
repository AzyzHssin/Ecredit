package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.Models.PieceJointe;
import com.Ecredit.demo.Service.PieceJointeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/ByTypeCredit/{id}")
    public ResponseEntity<List<PieceJointe>> getPieceJointeByTypeCredit(@PathVariable long id){
        return ResponseEntity.ok(pieceJointeService.getPieceJointeByTypeCredit(id));
    }
    @PostMapping("/add")
    public PieceJointe createPieceJointe(@RequestBody PieceJointe pieceJointe) {
        System.out.println("PieceJointe is created successefully");
        return pieceJointeService.createPieceJointe(pieceJointe);
    }
    @DeleteMapping("/{id}")
    public void deletePieceJointe(@PathVariable long id){
        pieceJointeService.deletePieceJointe(id);
    }
}
