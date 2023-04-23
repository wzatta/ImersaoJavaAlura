import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StickersavedComponent } from './stickersaved.component';

describe('StickersavedComponent', () => {
  let component: StickersavedComponent;
  let fixture: ComponentFixture<StickersavedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StickersavedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StickersavedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
