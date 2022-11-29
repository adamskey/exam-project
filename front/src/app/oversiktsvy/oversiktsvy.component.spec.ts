import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OversiktsvyComponent } from './oversiktsvy.component';

describe('OversiktsvyComponent', () => {
  let component: OversiktsvyComponent;
  let fixture: ComponentFixture<OversiktsvyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OversiktsvyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OversiktsvyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
