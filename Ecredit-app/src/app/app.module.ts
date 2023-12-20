import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DemandeCreditComponent } from './demande-credit/demande-credit.component';
import { ConsultationCreditComponent } from './consultation-credit/consultation-credit.component';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {ReactiveFormsModule,FormsModule} from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
////////////////////////////////PRIMENG///////////////////////////////
import {SplitterModule} from 'primeng/splitter';

import { DropdownModule } from 'primeng/dropdown';
import { DemCreditComponent } from './dem-credit/dem-credit.component';
import {InputTextModule} from 'primeng/inputtext';
import {CalendarModule} from 'primeng/calendar';
import {FieldsetModule} from 'primeng/fieldset';
import { CheckboxModule } from 'primeng/checkbox';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {FileUploadModule} from 'primeng/fileupload';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {DialogModule} from 'primeng/dialog';
import { ListboxModule } from 'primeng/listbox';

@NgModule({
  declarations: [
    AppComponent,
    DemandeCreditComponent,
    ConsultationCreditComponent,
    DemCreditComponent,

  ],
  imports: [
    DialogModule,
    ListboxModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatButtonModule,
    BrowserAnimationsModule,

    FormsModule,

    ReactiveFormsModule,
    CheckboxModule,
    DropdownModule,
    SplitterModule,
    InputTextModule,
    FieldsetModule,
    CalendarModule,
    TableModule,
    ButtonModule,
    FileUploadModule,
    InputTextareaModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
