import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorSubscriptionComponent } from './author-subscription.component';

describe('AuthorSubscriptionComponent', () => {
  let component: AuthorSubscriptionComponent;
  let fixture: ComponentFixture<AuthorSubscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorSubscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorSubscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
