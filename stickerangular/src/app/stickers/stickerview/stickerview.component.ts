import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, NonNullableFormBuilder, Validators } from '@angular/forms';
import { StickerservService } from '../../services/stickerserv.service';
import { Observable,  of } from 'rxjs';
import { Stickerdto } from '../model/stickerdto';
import { Imagemdto } from '../model/Imagemdto';
import { MatSnackBar } from '@angular/material/snack-bar';
import { StickersavedComponent } from '../stickersaved/stickersaved.component';
import { MatTabChangeEvent } from '@angular/material/tabs';




@Component({
  selector: 'app-stickerview',
  templateUrl: './stickerview.component.html',
  styleUrls: ['./stickerview.component.scss']
})
export class StickerviewComponent implements OnInit  {

@ViewChild(StickersavedComponent) private stickerSaved : StickersavedComponent | any;

  anime: Stickerdto | any = {};
  rick: Stickerdto | any = {};

  imgdto$ : Observable<Imagemdto> | null = null;
  imgdto : Imagemdto | any = {};

  anime$: Observable<Stickerdto> | null = null;
  rick$: Observable<Stickerdto> | null = null;

  figurinhas$ : Observable<Stickerdto[]>| null = null;
  figurinhas : Stickerdto[] = [];

  tipoDaFigurinha: string = "O Melhor";
  novafigurinha: string = "https://atletico.com.br/wp-content/uploads/2022/01/atletico.svg";

  novafigurinha$: Observable<string> | null =null;

  fig$ : Observable<Stickerdto> | null = null;
  fig : Stickerdto | any = {};

  queryField = new FormControl();

 formId = this.formBuilder.group({
      idfig:['',[Validators.required,
                  Validators.min(1),
                  Validators.max(1000)]]
  });

  formText = this.formBuilder.group({
    textView:['', [Validators.required]]
  })

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private stickerServ: StickerservService,
    private snackbar: MatSnackBar
  ){

  }

  ngOnInit(): void {
    this.tipoDaFigurinha = "O Melhor";
  this.novafigurinha = "https://atletico.com.br/wp-content/uploads/2022/01/atletico.svg";
  }




  onSubmit(){
    this.figurinhas$ = this.stickerServ.findFigById(this.formId.value);
  }

  onClickView(urlString: string){
    this.tipoDaFigurinha = "Original"
    this.novafigurinha = urlString;

  }

  onClickSave(record: Partial<Stickerdto>){
    this.stickerServ.saveFig(record)
    .subscribe({
      complete : ()=> {this.onSucess()},
      error : ()=> {this.onError()}
  });

  }

  onTabChanched(event: MatTabChangeEvent){
    if(event.index == 0){
      this.ngOnInit();
    } else{
      this.stickerSaved.ngOnInit();
    }

  }



  onSucess(){

    this.snackbar.open('Registro Salvo com Sucesso','',{duration:5000});
  }

  onError(): void {
    this.snackbar.open('Registro ja Cadastrado','',{duration:5000});
  }

  OnClickGeraFig(newSticker: Stickerdto): void{

   this.imgdto$ = this.stickerServ
    .geradorDeFigurinha(newSticker.imagemurldto, newSticker.titulodto, this.formText.value);

    this.imgdto$.subscribe(
      dados=>{
        newSticker.imagembase64 = dados.imgbase64;
        this.novafigurinha = "data:image/png;base64,".concat(newSticker.imagembase64);
        this.tipoDaFigurinha = "Nova Figurinha";
    }
    );



    this.formText.reset();

  }



  getErrorMessage(fieldName: string){

    const field = this.formId.get(fieldName);

    if(field?.hasError('required')){
      return 'Campo Obrigatório';
    }

    if(field?.hasError('min') || field?.hasError('max')){
      return 'valor deve ser de 1 a 1000 !';
    }

    return 'Campo Invalido';
  }

}
