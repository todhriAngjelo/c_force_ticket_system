import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeTicketShowComponent } from './home-ticket-show.component';

describe('HomeTicketShowComponent', () => {
  let component: HomeTicketShowComponent;
  let fixture: ComponentFixture<HomeTicketShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeTicketShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeTicketShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
