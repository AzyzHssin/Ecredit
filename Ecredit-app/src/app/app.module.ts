import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CheckboxModule } from 'primeng/checkbox';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DemandeCreditComponent } from './demande-credit/demande-credit.component';
import { ConsultationCreditComponent } from './consultation-credit/consultation-credit.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {ReactiveFormsModule,FormsModule} from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { DropdownModule } from 'primeng/dropdown';
@NgModule({
  declarations: [
    AppComponent,
    DemandeCreditComponent,
    ConsultationCreditComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    FormsModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    CheckboxModule,
    DropdownModule

  ],
  providers: [
    MatDatepickerModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
