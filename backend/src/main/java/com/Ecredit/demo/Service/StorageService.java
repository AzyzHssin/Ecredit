package com.Ecredit.demo.Service;





import com.Ecredit.demo.DemandeCredit.DemandeCreditRepo;
import com.Ecredit.demo.ScannedDocument.ScannedDocument;
import com.Ecredit.demo.ScannedDocument.ScannedDocumentRepository;
import com.Ecredit.demo.Util.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {


    private final ScannedDocumentRepository repository;

    public long uploadPdf(MultipartFile file) throws IOException {

        ScannedDocument pdfDAta = repository.save(ScannedDocument.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .pdfData(PdfUtils.compressPdf(file.getBytes())).build());


            return pdfDAta.getId();

    }

    public byte[] downloadPdf(long fileId){
        Optional<ScannedDocument> dbScannedDocument = repository.findById(fileId);
        return PdfUtils.decompressPdf(dbScannedDocument.get().getPdfData());
    }
}