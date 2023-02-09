import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorCreateBookComponent } from './author-create-book.component';

describe('AuthorCreateBookComponent', () => {
  let component: AuthorCreateBookComponent;
  let fixture: ComponentFixture<AuthorCreateBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorCreateBookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorCreateBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
