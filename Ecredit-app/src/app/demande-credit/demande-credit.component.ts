import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-demande-credit',
  templateUrl: './demande-credit.component.html',
  styleUrls: ['./demande-credit.component.css'],
  
  
})
export class DemandeCreditComponent implements OnInit {
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
  constructor(private _formBuilder:FormBuilder ) { }
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
  }

}
