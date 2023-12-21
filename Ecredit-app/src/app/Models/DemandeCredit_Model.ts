import { BankAccount } from "./BankAccount_Model";
import { DocumentFile } from "./DocumentFile_Model";
import { Guarantie } from "./Guarantie_Model";
import { TypeCredit } from "./TypeCredit_Model";
import { Unite } from "./Unite_Model";
import {ScannedDocument} from "./scanned-document.module"
export interface DemandeCredit {
  /*   id: number; */
    montant: number;
    nbreEcheance: number;
    observation: string;
    bankAccount: BankAccount;
    unite: Unite;
    typeCredit: TypeCredit;
    guaranties: Guarantie[];
   /*  documentFiles: DocumentFile[]; */
    scannedDocument:any;
  }
