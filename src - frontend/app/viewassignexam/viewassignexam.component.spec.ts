import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewassignexamComponent } from './viewassignexam.component';

describe('ViewassignexamComponent', () => {
  let component: ViewassignexamComponent;
  let fixture: ComponentFixture<ViewassignexamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewassignexamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewassignexamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
