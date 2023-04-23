import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StickerviewComponent } from './stickerview/stickerview.component';

const routes: Routes = [
  {path: '', component: StickerviewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StickersRoutingModule { }
