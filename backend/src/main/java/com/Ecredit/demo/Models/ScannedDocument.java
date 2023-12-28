package com.Ecredit.demo.ScannedDocument;
import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "SCANNEDDOCUMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScannedDocument {
    @Id
    @SequenceGenerator(name="scannedDocument",sequenceName ="scannedDocument",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "scannedDocument")
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "scannedData",length = 1000)
    private byte[] pdfData;
    @OneToOne
    private DemandeCredit demandeCredit;
}