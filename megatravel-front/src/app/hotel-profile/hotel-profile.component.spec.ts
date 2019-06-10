import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelProfileComponent } from './hotel-profile.component';

describe('HotelProfileComponent', () => {
  let component: HotelProfileComponent;
  let fixture: ComponentFixture<HotelProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
