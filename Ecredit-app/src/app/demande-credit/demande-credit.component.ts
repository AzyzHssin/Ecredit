import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { DemandeCredit } from '../Models/DemandeCredit_Model';
import {TypeCredit} from '../Models/TypeCredit_Model';
import { Unite } from './../Models/Unite_Model';
import { BankAccount } from '../Models/BankAccount_Model';
///////////////////////////////////////////////////////////////
import { DemandeService } from '../services/DemandeService';
import { UniteService } from '../services/unite.service';
import {TypecreditService} from '../services/typecredit.service'
import { BankaccountService } from '../services/bankaccount.service';
@Component({
  selector: 'app-demande-credit',
  templateUrl: './demande-credit.component.html',
  styleUrls: ['./demande-credit.component.css'],


})
export class DemandeCreditComponent implements OnInit {
  demandeCredit?:DemandeCredit[];
  typecreditArray?:TypeCredit[];
  uniteArray?:Unite[];
  bankAccountArray?:BankAccount[];
  selectedBankAccount?:BankAccount;
  ncin: number = 0;
  nom:string='';
  prenom:string='';
  devise:string='';
  dateOvertureCompte: Date | null = null;
  montant:number=0;
  nbreEcheance:number=0;
  observation:string='';
  selectedFiles: FileList | null = null;
  tablet = {
    items: [
      { name: 'iPod', brand: 'Apple', price: 499.99 },
      { name: 'Galaxy Tab', brand: 'Samsung', price: 349.99 },
      { name: 'Fire HD', brand: 'Amazon', price: 149.99 },
      // Add more items as needed
    ]
  };
  fetchedCustomer: boolean=false;
  constructor(private _formBuilder:FormBuilder,private demandeServ:DemandeService,private uniteServ:UniteService,private typecreditService:TypecreditService,private bankaccountService:BankaccountService )
   { }
  /////////////////////////Methods////////////////////////////////////
   showFormData(){
    console.log("Form values:", {
      ncin: this.ncin,
      nom: this.nom,
      prenom: this.prenom,
      devise: this.devise,
      dateOvertureCompte: this.dateOvertureCompte,
      montant:this.montant,
      nbreEcheance:this.nbreEcheance,
      selectedFiles:this.selectedFiles,
      observation:this.observation,
      selectedBankAccount:this.selectedBankAccount

    });
  }
  onCinChange(){
    if(this.ncin.toString().length===8){
      this.getBankAccountsByCustomerId(this.ncin);
      console.log("request fetch is executed using this id ncin:",this.ncin);
    }
    else{
      console.log("Ncin:",this.ncin);
    }
  }
  onFileChange(event: any) {
    this.selectedFiles = event.target.files;
    console.log('Selected files:', this.selectedFiles);
  }
  ngOnInit(): void {
    this.getUnite();
    this.getTypecredit();
  }
  getDemande(){
    this.demandeServ.getDemande().subscribe((data:any) => {
      this.demandeCredit = data;
    },
    (error:any) => {
      console.error('Error fetching demande data:', error);
    }
  );
  }
  getUnite(){
    this.uniteServ.getUnite().subscribe((data:Unite[])=>{
      this.uniteArray=data;
      console.log("data is detched ",data,"*********");
    },(error:any) => {
      console.error('Error fetching Unite data:', error);
    }
    )
  };

  getTypecredit(){
    this.typecreditService.getTypeCredit().subscribe((data:TypeCredit[])=>{
      this.typecreditArray=data;
      console.log("Type Credits is fetched",data,"--------------")
    },(error:any) => {
      console.error('Error fetching type credits data:', error);
    })
  };

  getBankAccountsByCustomerId(id:number){
    this.bankaccountService.getBankAccountByCustomer(id).subscribe((data:BankAccount[])=>{
      this.bankAccountArray=data;
      if(this.bankAccountArray.length!=0){
        this.nom=this.bankAccountArray[0].customer.firstName;
        this.prenom=this.bankAccountArray[0].customer.lastName;
        console.log("BankAccounts is fetched",data,"\n------------------------------")
        this.fetchedCustomer=true;
      }
      else{
        console.log("No bank account corresponding to this account");
        //Make toast
      }
    },(error:any) => {
      console.error('Error fetching BankAccounts data:', error);
    })
  }

  onSelectingAccount(): void {
    if (this.selectedBankAccount) {
      console.log('Selected bank account:', this.selectedBankAccount.id);

      this.dateOvertureCompte = new Date(this.selectedBankAccount.createDate);
      //this.devise = this.selectedBankAccount.currency; // Adjust to your actual property name
    } else {
      console.warn('Selected bank account is undefined.');
    }
  }
}
