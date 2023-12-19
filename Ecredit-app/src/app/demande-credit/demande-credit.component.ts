import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';

import { DemandeCredit } from '../Models/DemandeCredit_Model';
import {TypeCredit} from '../Models/TypeCredit_Model';
import { Unite } from './../Models/Unite_Model';
import { BankAccount } from '../Models/BankAccount_Model';
import { PieceJointe } from './../Models/PieceJointe_Model';
///////////////////////////////////////////////////////////////
import { DemandeService } from '../services/DemandeService';
import { UniteService } from '../services/unite.service';
import {TypecreditService} from '../services/typecredit.service'
import { BankaccountService } from '../services/bankaccount.service';
import { PiecesjointesService } from './../services/piecesjointes.service';
////////////////////////////////////////////////////////////////
@Component({
  selector: 'app-demande-credit',
  templateUrl: './demande-credit.component.html',
  styleUrls: ['./demande-credit.component.css'],


})
export class DemandeCreditComponent implements OnInit {
  demandeCredit!: DemandeCredit[];
  typecreditArray!:TypeCredit[];
  uniteArray?:Unite[];
  bankAccountArray?:BankAccount[];
  PieceJointeArray?:PieceJointe[];
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
  selectedTypeCredit?:TypeCredit;
  FilesToRender?:any[];
  checked: boolean = false;
  obligedDocuments: string[]=[];
  tablet = {
    items: [
      { name: 'iPod', brand: 'Apple', price: 499.99 },
      { name: 'Galaxy Tab', brand: 'Samsung', price: 349.99 },
      { name: 'Fire HD', brand: 'Amazon', price: 149.99 },
      // Add more items as needed
    ]
  };
  fetchedCustomer: boolean=false;
cities: any[]= [
  {name: 'New York', code: 'NY'},
  {name: 'Rome', code: 'RM'},
  {name: 'London', code: 'LDN'},
  {name: 'Istanbul', code: 'IST'},
  {name: 'Paris', code: 'PRS'}
];
;
  constructor(private _formBuilder:FormBuilder,private piecesjointesService:PiecesjointesService,private demandeServ:DemandeService,private uniteServ:UniteService,private typecreditService:TypecreditService,private bankaccountService:BankaccountService )
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
      selectedBankAccount:this.selectedBankAccount,
      selectedTypeCredit:this.selectedTypeCredit,
      typecreditArray:this.typecreditArray
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
    /* this.FilesToRender=Array.from(this.selectedFiles); */
  }
  ngOnInit(): void {
    this.getUnite();
    this.getTypecredit();
    this.getPiecesJointes();
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
  getPiecesJointes(){
    this.piecesjointesService.getPiecesJointes().subscribe((data:PieceJointe[])=>{
      this.PieceJointeArray=data;
      console.log("Pieces Jointes are fetched \n",this.PieceJointeArray);
    },(error:any) => {
      console.error('Error fetching Pieces Jointes data:', error);
    });
  }
  onSelectTypeCredit(){
    console.log("this.selectedTypeCredit: ",this.selectedTypeCredit)
    if(this.selectedTypeCredit){
      this.piecesjointesService.getPiecesJointesByTypeCredit(this.selectedTypeCredit.id).subscribe((data:PieceJointe[])=>{
        this.obligedDocuments=data.map(data=>data.nom);
        console.log("obliged docs ",this.obligedDocuments);


      })
      console.log("request fetch is executed using this id : ",this.selectedTypeCredit.id);
    }
    else{
      console.warn("no Type Credit is selected to fetch pieces jointes")
    }
  }
}
