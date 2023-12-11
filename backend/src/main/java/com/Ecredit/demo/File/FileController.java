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
public class FileController {
    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<File>> getAllFile() {
        List<File> FileList = fileService.getAllFile();
        return new ResponseEntity<>(FileList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<File> getFileById(@PathVariable long   id){
        return fileService.getFileById(id);
    }
    @PostMapping("/add")
    public File createFile(@RequestBody File file) {
        System.out.println("file is created successefully");
        return fileService.createFile(file);
    }
    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable long id){
        fileService.deleteFile(id);
    }
}