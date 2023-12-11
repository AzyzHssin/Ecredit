import { SituationFamiliale } from "./SituationFamiliale_Model";
import { BankAccount } from "./BankAccount_Model";
export interface Customer {
    cin: number;
    lastName: string;
    firstName: string;
    birthday: Date;
    listOfAccounts: BankAccount[];
    situationFamiliale: SituationFamiliale;
  }