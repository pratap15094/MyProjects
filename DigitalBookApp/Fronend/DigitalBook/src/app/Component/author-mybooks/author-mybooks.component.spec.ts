import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorMybooksComponent } from './author-mybooks.component';

describe('AuthorMybooksComponent', () => {
  let component: AuthorMybooksComponent;
  let fixture: ComponentFixture<AuthorMybooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorMybooksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorMybooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
