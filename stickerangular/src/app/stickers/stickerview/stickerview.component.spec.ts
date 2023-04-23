import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StickerviewComponent } from './stickerview.component';

describe('StickerviewComponent', () => {
  let component: StickerviewComponent;
  let fixture: ComponentFixture<StickerviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StickerviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StickerviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
