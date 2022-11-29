import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaljvyComponent } from './detaljvy.component';

describe('DetaljvyComponent', () => {
  let component: DetaljvyComponent;
  let fixture: ComponentFixture<DetaljvyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetaljvyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetaljvyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
