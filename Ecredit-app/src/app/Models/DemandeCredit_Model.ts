import { BankAccount } from "./BankAccount_Model";
import { DocumentFile } from "./DocumentFile_Model";
import { Guarantie } from "./Guarantie_Model";
import { TypeCredit } from "./TypeCredit_Model";
import { Unite } from "./Unite_Model";

export interface DemandeCredit {
    id: number;
    montant: number;
    nbreEcheance: number;
    Observation: string;
    bankAccount: BankAccount;
    unite: Unite;
    typeCredit: TypeCredit;
    guaranties: Guarantie[];
    documentFiles: DocumentFile[];
  }