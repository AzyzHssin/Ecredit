import { DemandeCredit } from "./DemandeCredit_Model";

export interface DocumentFile {
    id: number;
    data: string;
    demandeCredit: DemandeCredit;
  }