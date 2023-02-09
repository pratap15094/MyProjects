import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorUpdateBookComponent } from './author-update-book.component';

describe('AuthorUpdateBookComponent', () => {
  let component: AuthorUpdateBookComponent;
  let fixture: ComponentFixture<AuthorUpdateBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorUpdateBookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorUpdateBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
