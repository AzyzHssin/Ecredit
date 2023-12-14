import { Unite } from './../Models/Unite_Model';

import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { DemandeCredit } from '../Models/DemandeCredit_Model';
import { DemandeService } from '../services/DemandeService';
import { UniteService } from '../services/unite.service';
@Component({
  selector: 'app-demande-credit',
  templateUrl: './demande-credit.component.html',
  styleUrls: ['./demande-credit.component.css'],


})
export class DemandeCreditComponent implements OnInit {
  demandeCredit?:DemandeCredit[]
  uniteArray?:Unite[]
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
  constructor(private _formBuilder:FormBuilder,private demandeServ:DemandeService,private uniteServ:UniteService ) { }
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

    });
  }
  onFileChange(event: any) {
    this.selectedFiles = event.target.files;
    console.log('Selected files:', this.selectedFiles);
  }
  ngOnInit(): void {
    this.getUnite();
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
  }

}
