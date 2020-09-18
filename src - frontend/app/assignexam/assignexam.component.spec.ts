import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignexamComponent } from './assignexam.component';

describe('AssignexamComponent', () => {
  let component: AssignexamComponent;
  let fixture: ComponentFixture<AssignexamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignexamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignexamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
