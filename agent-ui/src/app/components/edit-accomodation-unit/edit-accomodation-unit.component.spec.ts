import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAccomodationUnitComponent } from './edit-accomodation-unit.component';

describe('EditAccomodationUnitComponent', () => {
  let component: EditAccomodationUnitComponent;
  let fixture: ComponentFixture<EditAccomodationUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAccomodationUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAccomodationUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
