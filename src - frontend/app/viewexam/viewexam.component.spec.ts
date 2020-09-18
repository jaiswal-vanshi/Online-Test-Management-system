import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewexamComponent } from './viewexam.component';

describe('ViewexamComponent', () => {
  let component: ViewexamComponent;
  let fixture: ComponentFixture<ViewexamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewexamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewexamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
