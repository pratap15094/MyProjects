import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorBlockbookComponent } from './author-blockbook.component';

describe('AuthorBlockbookComponent', () => {
  let component: AuthorBlockbookComponent;
  let fixture: ComponentFixture<AuthorBlockbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorBlockbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorBlockbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
