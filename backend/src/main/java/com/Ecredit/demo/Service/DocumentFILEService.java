package com.Ecredit.demo.File;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.Ecredit.demo.DemandeCredit.DemandeCreditRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentFILEService {
    private final DocumentFILERepo documentFILERepo;
    private final DemandeCreditRepo demandeCreditRepo;
    public List<DocumentFile> getAllFile (){
        return documentFILERepo.findAll();
    }
    public Optional<DocumentFile> getFileById(long id){return documentFILERepo.findById(id);}
    public DocumentFile createFile(DocumentFile file) {
        DemandeCredit demandeCredit =demandeCreditRepo.findById(file.getDemandeCredit().getId()).orElse(null);
        assert demandeCredit != null;
        demandeCredit.getDocumentFiles().add(file);
        documentFILERepo.save(file);

        demandeCreditRepo.save(demandeCredit);
        return file;
    }
    public List<DocumentFile> createMultipleFile(List<DocumentFile> files){
        for (DocumentFile file: files) {
            DemandeCredit demandeCredit =demandeCreditRepo.findById(file.getDemandeCredit().getId()).orElse(null);
            assert demandeCredit != null;
            demandeCredit.getDocumentFiles().add(file);
            documentFILERepo.save(file);
            demandeCreditRepo.save(demandeCredit);
        }

        return files;
    }
    public void deleteFile(Long id) {
        documentFILERepo.deleteById(id);
    }
}