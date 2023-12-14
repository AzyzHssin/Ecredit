import { TestBed } from '@angular/core/testing';

import { TypecreditService } from './typecredit.service';

describe('TypecreditService', () => {
  let service: TypecreditService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypecreditService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
