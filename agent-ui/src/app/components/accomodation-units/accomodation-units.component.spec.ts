import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccomodationUnitsComponent } from './accomodation-units.component';

describe('AccomodationUnitsComponent', () => {
  let component: AccomodationUnitsComponent;
  let fixture: ComponentFixture<AccomodationUnitsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccomodationUnitsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccomodationUnitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
