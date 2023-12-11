package com.Ecredit.demo.File;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/File")
public class DocumentFILEController {
    private final DocumentFILEService documentFILEService;

    @GetMapping
    public ResponseEntity<List<DocumentFile>> getAllFile() {
        List<DocumentFile> FileList = documentFILEService.getAllFile();
        return new ResponseEntity<>(FileList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<DocumentFile> getFileById(@PathVariable long   id){
        return documentFILEService.getFileById(id);
    }
    @PostMapping("/add")
    public DocumentFile createFile(@RequestBody DocumentFile file) {
        System.out.println("file is created successefully");
        return documentFILEService.createFile(file);
    }
    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable long id){
        documentFILEService.deleteFile(id);
    }
}