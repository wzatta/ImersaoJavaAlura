import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StickersRoutingModule } from './stickers-routing.module';
import { StickerviewComponent } from './stickerview/stickerview.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { StickersavedComponent } from './stickersaved/stickersaved.component';


@NgModule({
  declarations: [
    StickerviewComponent,
    StickersavedComponent
  ],
  imports: [
    CommonModule,
    StickersRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule,


  ]
})
export class StickersModule { }
