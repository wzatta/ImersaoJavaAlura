import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Stickerdto } from '../stickers/model/stickerdto';
import { Observable, from, of, tap } from 'rxjs';
import { Pesquisa } from '../stickers/model/pesquisa';
import { Imagemdto } from '../stickers/model/Imagemdto';
import { TextView } from '../stickers/model/TextView';

@Injectable({
  providedIn: 'root'
})
export class StickerservService {

  private readonly APINEWFIG = "api/v1/newfig"
  private readonly APIFIG = "api/v1/fig"
  private readonly APIANIME = "api/v1/anime";
  private readonly APIRICK = "api/v1/rickmorty";
  private readonly API = "api/v1/gerafig/view"


  fig$: Observable<Stickerdto[]> | any = [];
  fig: Stickerdto[] = [];



  constructor(
    private httpClient: HttpClient
  ) { }


    findFigAll(){
      return this.httpClient.get<Stickerdto[]>(this.APINEWFIG);
    }

  findFigById(record: Partial<Pesquisa>) {
    return this.httpClient.get<Stickerdto[]>(this.APIFIG + "/" + record.idfig);
  }

  saveFig(record: Partial<Stickerdto>): Observable<Stickerdto> {

   // console.log("Waldyr "+record.id);
   // console.log("idoriginal "+record.idoriginaldto);
    //console.log("imagemurldto "+record.imagemurldto);
    //console.log("notadto "+record.notadto);
    //console.log("textodto "+record.textodto);
    //console.log("tipodto "+record.tipodto);
    //console.log("titulodto "+record.titulodto);
    //console.log("imagembase64 "+record.imagembase64);


    return this.httpClient.post<Stickerdto>(this.APINEWFIG, record);

  }

  deleteReg(sticker: Stickerdto){
     return this.httpClient.delete<Stickerdto>(this.APINEWFIG+"/"+sticker.id);
  }





  findAnimeById(record: Partial<Pesquisa>) {
    return this.httpClient.get<Stickerdto>(this.APIANIME + "/" + record.idfig);
  }

  findRickById(record: Partial<Pesquisa>) {
    return this.httpClient.get<Stickerdto>(this.APIRICK + "/" + record.idfig);
  }


  geradorDeFigurinha(url: String, titulo: String, record: Partial<TextView>) {

    return this.httpClient.get<Imagemdto>(this.API + '?url=' + url + '&nomeArquivo=' + titulo + '&msg=' + record.textView);
  }





}
