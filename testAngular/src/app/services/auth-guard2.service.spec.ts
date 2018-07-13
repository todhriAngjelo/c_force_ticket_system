import { TestBed, inject } from '@angular/core/testing';

import { AuthGuard2Service } from './auth-guard2.service';

describe('AuthGuard2Service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthGuard2Service]
    });
  });

  it('should be created', inject([AuthGuard2Service], (service: AuthGuard2Service) => {
    expect(service).toBeTruthy();
  }));
});
