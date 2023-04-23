import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StickersModule } from './stickers/stickers.module';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'stickers'},
  {
    path: 'stickers',
    loadChildren: () => import('./stickers/stickers.module').then(m => m.StickersModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
