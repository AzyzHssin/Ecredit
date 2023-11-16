import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemandeCreditComponent } from './demande-credit/demande-credit.component';
import { ConsultationCreditComponent } from './consultation-credit/consultation-credit.component';

const routes: Routes = [
  {path:'DemandeCredit',component:DemandeCreditComponent},
  {path:'ConsultationCredit',component:ConsultationCreditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
