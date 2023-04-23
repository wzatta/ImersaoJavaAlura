import { TestBed } from '@angular/core/testing';

import { StickerservService } from './stickerserv.service';

describe('StickerservService', () => {
  let service: StickerservService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StickerservService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
