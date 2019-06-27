import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccomodationImagesComponent } from './accomodation-images.component';

describe('AccomodationImagesComponent', () => {
  let component: AccomodationImagesComponent;
  let fixture: ComponentFixture<AccomodationImagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccomodationImagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccomodationImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
