import { TypeCredit } from "./TypeCredit_Model";

export interface PieceJointe {
    id: number;
    nom: string;
    obligatoire: string;
    typeCredit: TypeCredit;
  }
