import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccomodationUnitComponent } from './accomodation-unit.component';

describe('AccomodationUnitComponent', () => {
  let component: AccomodationUnitComponent;
  let fixture: ComponentFixture<AccomodationUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccomodationUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccomodationUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
