import { Byte } from '@angular/compiler/src/util';

export interface ScannedDocument {
    id: number;
    name:string;
    type:string;
    pdfData:Byte[];

  }
