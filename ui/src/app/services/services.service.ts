import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

// GET     /api/getclubdata                     controllers.HomeController.clubData()
// GET     /api/getmatchdata                     controllers.HomeController.matchData()
// GET     /api/automatchgen                       controllers.HomeController.genMatch()

export class ServicesService {
  private link = '/api/getclubdata';
  private match = '/api/getmatchdata';
  private genMatch = '/api/automatchgen ';

  constructor(private httpClient:HttpClient) { }

  

  public getAllService(){
    return this.httpClient.get(this.link);
  }

  public getMatchService() {
    return this.httpClient.get(this.match);
  }

  public generateMatch() {
    return this.httpClient.get(this.genMatch);
  }
}