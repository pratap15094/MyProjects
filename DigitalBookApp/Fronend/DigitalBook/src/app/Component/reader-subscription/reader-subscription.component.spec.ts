import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderSubscriptionComponent } from './reader-subscription.component';

describe('ReaderSubscriptionComponent', () => {
  let component: ReaderSubscriptionComponent;
  let fixture: ComponentFixture<ReaderSubscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReaderSubscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReaderSubscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
