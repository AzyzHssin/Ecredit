import { PieceJointe } from "./PieceJointe_Model";

export interface TypeCredit {
    id: number;
    nom: string;
    piecesJointes: PieceJointe[];
  }