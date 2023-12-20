import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemCreditComponent } from './dem-credit.component';

describe('DemCreditComponent', () => {
  let component: DemCreditComponent;
  let fixture: ComponentFixture<DemCreditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemCreditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemCreditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
