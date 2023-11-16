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

   tablet = {
    items: [
      { name: 'iPad', brand: 'Apple', price: 499.99 },
      { name: 'Galaxy Tab', brand: 'Samsung', price: 349.99 },
      { name: 'Fire HD', brand: 'Amazon', price: 149.99 },
      // Add more items as needed
    ]
  };
  constructor(private _formBuilder:FormBuilder ) { }

  ngOnInit(): void {
  }

}
