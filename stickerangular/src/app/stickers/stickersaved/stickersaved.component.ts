import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Stickerdto } from '../model/stickerdto';
import { StickerservService } from 'src/app/services/stickerserv.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-stickersaved',
  templateUrl: './stickersaved.component.html',
  styleUrls: ['./stickersaved.component.scss']
})
export class StickersavedComponent implements OnInit {

  figurinhas$:Observable<Stickerdto[]> | null = null;
  novafigurinha: String = "https://atletico.com.br/wp-content/uploads/2022/01/atletico.svg";
  tipoDaFigurinha: string = "O Melhor";
  base:string = "data:image/png;base64,"
  constructor(
    private stickerServ: StickerservService,
    private snackbar : MatSnackBar
  ){

  }


ngOnInit(): void {

this.findFigAll();
this.novafigurinha = "https://atletico.com.br/wp-content/uploads/2022/01/atletico.svg";

}


findFigAll(){

  this.figurinhas$ = this.stickerServ.findFigAll();

}


onClickView(imgstring: string){
  this.novafigurinha = "data:image/png;base64,".concat(imgstring);
  this.tipoDaFigurinha = "Sticker Salvo"
}

onClickDelete(sticker: Stickerdto){
    console.log(sticker.id);
  this.stickerServ.deleteReg(sticker).subscribe({
    complete: ()=> { this.onSucess()},
    error: ()=> {this.onError()}
  });
}

onSucess(){
  this.snackbar.open('Registro Excluido Com Sucesso','',{duration:5000});
  this.ngOnInit();
}

onError(){

}


}
