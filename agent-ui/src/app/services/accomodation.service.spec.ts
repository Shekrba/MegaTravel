import { TestBed } from '@angular/core/testing';

import { AccomodationService } from './accomodation.service';

describe('AccomodationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccomodationService = TestBed.get(AccomodationService);
    expect(service).toBeTruthy();
  });
});
