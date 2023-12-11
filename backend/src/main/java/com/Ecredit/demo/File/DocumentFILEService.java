package com.Ecredit.demo.File;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.Ecredit.demo.DemandeCredit.DemandeCreditRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepo fileRepo;
    private final DemandeCreditRepo demandeCreditRepo;
    public List<File> getAllFile (){
        return fileRepo.findAll();
    }
    public Optional<File> getFileById(long id){return fileRepo.findById(id);}
    public File createFile(File file) {
        DemandeCredit demandeCredit =demandeCreditRepo.findById(file.getDemandeCredit().getId()).orElse(null);
        assert demandeCredit != null;
        demandeCredit.getFileList().add(file);
        fileRepo.save(file);

        demandeCreditRepo.save(demandeCredit);
        return file;
    }
    public List<File> createMultipleFile(List<File> files){
        for (File file: files) {
            DemandeCredit demandeCredit =demandeCreditRepo.findById(file.getDemandeCredit().getId()).orElse(null);
            assert demandeCredit != null;
            demandeCredit.getFileList().add(file);
            fileRepo.save(file);
            demandeCreditRepo.save(demandeCredit);
        }

        return files;
    }
    public void deleteFile(Long id) {
        fileRepo.deleteById(id);
    }
}