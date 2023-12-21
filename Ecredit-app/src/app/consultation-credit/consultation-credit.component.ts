import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultation-credit',
  templateUrl: './consultation-credit.component.html',
  styleUrls: ['./consultation-credit.component.css']
})
export class ConsultationCreditComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  cities: any[]= [
    {name: 'New York', code: 'NY'},
    {name: 'Rome', code: 'RM'},
    {name: 'London', code: 'LDN'},
    {name: 'Istanbul', code: 'IST'},
    {name: 'Paris', code: 'PRS'}
  ];
}
