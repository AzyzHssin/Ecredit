import { Customer } from "./Customer_Model";

export interface BankAccount {
    id: number;
    solde: number;
    createDate: Date;
    customer: Customer;
    demandeCredits: DemandeCredit[];
  }