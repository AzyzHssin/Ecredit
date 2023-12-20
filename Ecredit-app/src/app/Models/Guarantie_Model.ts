import { DemandeCredit } from "./DemandeCredit_Model";
import { Devise } from "./Devise_Model";
import { NatureGuarantie } from "./NatureGuarantie_Model";
import { TypeGuarantie } from "./TypeGuarantie_Model";

export interface Guarantie {
    /* id: number; */
    valeur: number;
    natureGuarantie: NatureGuarantie;
    devise: Devise;
    typeGuarantie: TypeGuarantie;
    /* demandeCredit: DemandeCredit; */
  }
