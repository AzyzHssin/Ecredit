
import {MessageService} from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import { SacannedDocumentService } from './../services/ScannedDocument.service';
import { Guarantie } from './../Models/Guarantie_Model';
import { GuarantieService } from './../services/guarantie.service';
import { Location } from '@angular/common';
import { TypeGarantieService } from './../services/type-garantie.service';
import { DeviseGarantieService } from './../services/devise-garantie.service';
import { NatureGarantieService } from './../services/nature-garantie.service';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, NgForm, Validators} from '@angular/forms';
import {SituationFamiliale} from '../Models/SituationFamiliale_Model'
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
import { NatureGuarantie } from '../Models/NatureGuarantie_Model';
import { TypeGuarantie } from '../Models/TypeGuarantie_Model';
import { Devise } from '../Models/Devise_Model';
////////////////////////////////////////////////////////////////
@Component({
  selector: 'app-dem-credit',
  templateUrl: './dem-credit.component.html',
  styleUrls: ['./dem-credit.component.css'],
  providers: [MessageService]

})
export class DemCreditComponent implements OnInit {
  guarantiesArrayOfDemand:Guarantie[]=[];
  demandeCredit!: DemandeCredit[];
  typecreditArray!:TypeCredit[];
  uniteArray!:Unite[];
  bankAccountArray!:BankAccount[];
  PieceJointeArray!:PieceJointe[];
  NatureGarantieArray!:NatureGuarantie[];
  TypeGarantieArray!:TypeGuarantie[];
  DeviseGarantieArray!:Devise[];
  selectedBankAccount!:BankAccount;
  ncin!: number ;
  nom:string='';
  prenom:string='';
  devise:string='';
  dateOvertureCompte: Date | null = null;
  birthday: Date | null = null;
  situationFamiliale!:string;

  montant!:number;
  unite!:Unite;
  nbreEcheance!:number;
  frontnbreEcheance!:number;
  observation!:string;
  selectedFile: any;
  selectedTypeCredit!:TypeCredit;

  checked: boolean = false;
  obligedDocuments: string[]=[];
  displayModal: boolean=false;
  displayMaximizable: boolean=false;
  NatureGarantieInput!:NatureGuarantie;
  TypeGarantieInput!:TypeGuarantie;
  ValeurGarantieInput:number=0;
  DeviseGarantieInput!:Devise;

  nn!:NatureGuarantie;
  tt!:TypeGuarantie;
  vv!:number;
  dd!:Devise;

  fetchedCustomer: boolean=false;

  idDocument!: number;

  natureUpdateState!:NatureGuarantie;
  typeUpdateState!:TypeGuarantie;
  valeurUpdateState!:number;
  deviseUpdateState!:Devise;

  constructor(private _formBuilder:FormBuilder,private piecesjointesService:PiecesjointesService,private demandeServ:DemandeService,private uniteServ:UniteService,
    private typecreditService:TypecreditService,private bankaccountService:BankaccountService,
    private typeGarantieService:TypeGarantieService,private deviseGarantieService:DeviseGarantieService,private natureGarantieService:NatureGarantieService,
    private guarantieService:GuarantieService,private sacannedDocumentService:SacannedDocumentService,private messageService: MessageService, private primengConfig: PrimeNGConfig,
    private location: Location
    )
   { }
   ngOnInit(): void {
    this.getUnite();
    this.getTypecredit();
    this.getPiecesJointes();
    this.getTypeGarantieRequest();
    this.getNatureGarantieRequest();
    this.getDeviseGarantieRequest();
  }
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
      unite:this.unite,
      selectedFile:this.selectedFile,
      observation:this.observation,
      selectedBankAccount:this.selectedBankAccount,
      selectedTypeCredit:this.selectedTypeCredit,
      typecreditArray:this.typecreditArray,
      scannedDocument:this.idDocument,
      guarantiesArrayOfDemand:this.guarantiesArrayOfDemand
    });
  }
  isPositiveInteger(value: any): boolean {
    // Check if the value is a positive integer
    const integerValue = parseInt(value, 10);
    return Number.isInteger(integerValue) && integerValue >= 0;
  }
  onUpdateGarantie(oldGuarantie:Guarantie){

    const objUpdate:Guarantie = {
      "id": oldGuarantie.id,
      "valeur": this.valeurUpdateState,
      "devise": this.deviseUpdateState,
      "natureGuarantie": this.natureUpdateState,
      "typeGuarantie": this.typeUpdateState,

    };
    this.guarantieService.updateGarantie(objUpdate).subscribe((data:any)=>{
      data.demandeCredits=null;
      this.guarantiesArrayOfDemand = this.guarantiesArrayOfDemand.filter(item => item.id !== objUpdate.id);
      this.guarantiesArrayOfDemand.push(data)
      console.log("after update ",this.guarantiesArrayOfDemand);
      this.showSuccess("Garantie est modifié")

    })

    this.displayMaximizable=false
  }
  getTypeGarantieRequest(){
    this.typeGarantieService.getTypeGarantie().subscribe((data:TypeGuarantie[])=>{
      this.TypeGarantieArray=data;
      console.log("Type Garantie is fetched",data,"--------------")
    },(error:any) => {
      console.error('Error fetching type Garantie data:', error);
    });
  }
  getNatureGarantieRequest(){
    this.natureGarantieService.getNatureGarantie().subscribe((data:NatureGuarantie[])=>{
      this.NatureGarantieArray=data;
      console.log(" NatureGuarantie is fetched",data,"--------------")
    },(error:any) => {
      console.error('Error fetching NatureGuarantie data:', error);
    });

  }
  getDeviseGarantieRequest(){
    this.deviseGarantieService.getDeviseGarantie().subscribe((data:Devise[])=>{
      this.DeviseGarantieArray=data;
      console.log(" DeviseGarantie is fetched",data,"--------------")
    },(error:any) => {
      console.error('Error fetching DeviseGarantie data:', error);
    });

}
  showModalDialog() {
    this.displayModal = true;
}
showMaximizableDialog(guarantie:any) {
  this.displayMaximizable = true;
  //
  this.natureUpdateState=guarantie.natureGuarantie;
  this.deviseUpdateState=guarantie.devise;
  this.typeUpdateState=guarantie.TypeGuarantie;
  this.valeurUpdateState=guarantie.valeur;
}
showStateNature(){
  console.log(this.NatureGarantieInput);
}
showStateDeviseGarantie(){
  console.log(this.DeviseGarantieInput);
}
showStateTypeGuarantie(){
  console.log(this.TypeGarantieInput)
}
onConfirmDialog(){
  const objectGarantieToSave:Guarantie = {
    "id":null,
    "valeur": this.ValeurGarantieInput,
    "devise": this.DeviseGarantieInput,
    "natureGuarantie": this.NatureGarantieInput,
    "typeGuarantie": this.TypeGarantieInput
  };
this.guarantieService.addGuarantie(objectGarantieToSave).subscribe((data:any)=>{
  this.guarantiesArrayOfDemand.push(data);
  this.ValeurGarantieInput=this.vv;
  this.DeviseGarantieInput=this.dd;
  this.NatureGarantieInput=this.nn;
  this.TypeGarantieInput=this.tt;
  this.showSuccess(`Guarantie est ajouté`)
})
}

deleteGarantieElement(value:Guarantie){
  this.guarantieService.deleteGuarantie(value.id).subscribe(data=>{
    this.guarantiesArrayOfDemand=this.guarantiesArrayOfDemand.filter(item=>item!==value);
   console.log("tab after deleting one element ",this.guarantiesArrayOfDemand);
    this.showSuccess("Guarantie est supprimé")
  })

}

  onCinChange(){
    console.log("on cin change is executed with cin value :",this.ncin)
    if(this.ncin.toString().length===8){
      this.getBankAccountsByCustomerId(this.ncin);
      console.log("request fetch is executed using this id ncin:",this.ncin);

    }
    else{
      console.log("Ncin:",this.ncin);
    }
  }
  onFileChange(event: any) {
    this.selectedFile = event.files;
    console.log('Selected file:', this.selectedFile);

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
        this.showSuccess(`Le system a trouvé le client de la carte cin numero: ${id} `)
        this.nom=this.bankAccountArray[0].customer.firstName;
        this.prenom=this.bankAccountArray[0].customer.lastName;
        this.birthday=new Date(this.bankAccountArray[0].customer.birthday);
        this.situationFamiliale=this.bankAccountArray[0].customer.situationFamiliale.situation;
       /*  this.dateOvertureCompte=new Date(this.bankAccountArray[0].createDate); */
        console.log("BankAccounts is fetched",data,"\n------------------------------")
        this.fetchedCustomer=true;
        this.showSuccess(`Le system a trouvé les comptes bancaires de client qu'il a la carte cin numero: ${id}`)
      }
      else{
        console.log("No bank account corresponding to this account");
        //Make toast
        this.showError(`le client de la carte cin ${id} n'esxiste pas dans le system`)

      }
    },(error:any) => {
      console.error('Error fetching BankAccounts data:', error);
    })
  }

  onSelectingAccount(): void {
    if (this.selectedBankAccount) {
      console.log('Selected bank account:', this.selectedBankAccount.id);
      this.devise=this.selectedBankAccount.devise;
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
  onChangeUnite(){
    console.log("this.unite on on changing the unite: ",this.unite.nom)
    if(this.unite.nom.includes( "mensuelle")) {
        this.nbreEcheance = 12;


    }
      else if (this.unite.nom.includes("trimestrielle")) {
        this.nbreEcheance = 4
      }
      else if (this.unite.nom.includes("semestrielle")) {
        this.nbreEcheance =2
    }
  }
  onSelectTypeCredit(){
    console.log("this.selectedTypeCredit: ",this.selectedTypeCredit)
    if(this.selectedTypeCredit){
      this.nbreEcheance=this.selectedTypeCredit.nbrEcheance;
      console.log("this.nbreEcheance:",this.nbreEcheance)
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
  submit(addForm:NgForm){
    console.log("submit is executed")
    this.showFormData();
    if(this.selectedFile){
      this.selectedFile.forEach((file: File) => {
      this.sacannedDocumentService.uploadPdf(file).subscribe((data:number)=>{
        this.showSuccess("fichier est ajouté")
           this.idDocument=data;
           console.log("id of new doc scanned is (from database) ",this.idDocument);
           this.selectedTypeCredit.nbrEcheance=this.nbreEcheance;
          const demande:DemandeCredit={
            "montant":this.montant,
           /*  "nbreEcheance":this.nbreEcheance, */
            "observation":this.observation,
             "bankAccount":this.selectedBankAccount,
            "unite":this.unite,
            "dateDemande":new Date(),
            "typeCredit":this.selectedTypeCredit,
            "guaranties":this.guarantiesArrayOfDemand,
            "scannedDocument":{"id":this.idDocument},
            "etat":""
          };
          this.demandeServ.addDemande(demande).subscribe((dataResponse:any )=>{
             console.log(dataResponse,"is saved")
             this.showSuccess("Votre demande à été envoyé");
             addForm.resetForm()
            },(error:any)=>{
              this.showError("Echec :verifier vos donner");
            });
      }

      );
      this.showFormData();
    });
  }else{
    console.log("plz upload file");
    this.showError("mettez les pieces jointes");
  }

  }
  refreshPage(addForm:NgForm): void {
    addForm.resetForm()
    window.scroll(0,0)
  }
  //////////////////////////////////////Toasts////////////////////////////////////////
  showSuccess(msg:string) {
    this.messageService.add({severity:'success', summary: 'Success', detail:msg});
}
showError(msg:string) {
  this.messageService.add({severity:'error', summary: 'Error', detail: msg});
}
}


