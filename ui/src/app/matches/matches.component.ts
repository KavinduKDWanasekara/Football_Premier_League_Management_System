import { CompileShallowModuleMetadata } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {ServicesService } from '../services/services.service';
import { Imatch } from '../types/service.type';
import {animate, state, style, transition, trigger} from '@angular/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})

// "team1": "oshan",
//         "team2": "navindu",
//         "team1Goals": 1,
//         "team2Goals": 5,
//         "matchDate": {
//             "day": 1,
//             "month": 1,
//             "year": 2021
//         },
//         "win": "navindu"

export class MatchesComponent implements OnInit {

  dateTo: string;

  ELEMENT_DATA : any;
  displayedColumns: string[] = ['team1', 'team2', 'team1Goals', 'team2Goals', 'matchDate', 'win'];
  
  constructor(public Serviceservice:ServicesService) {

   }

  public getMatchService() {
    let response = this.Serviceservice.getMatchService()
    response.subscribe(report=>{
      this.ELEMENT_DATA = report as Imatch[];
      this.ELEMENT_DATA.data=report as Imatch[]})
  }

  public gen() {

    let response = this.Serviceservice.generateMatch()
    
    response.subscribe(report=>{
      this.ELEMENT_DATA = report as Imatch[];
      this.ELEMENT_DATA.data=report as Imatch[]})
    }
  

  ngOnInit() {
    this.getMatchService();
  }

  search(){
    if(this.dateTo == ""){
      this.ngOnInit();
    }else{
      this.ELEMENT_DATA = this.ELEMENT_DATA.filter(res =>{
        let matchDate: string = res.matchDate.day.toString()  + "/" + res.matchDate.month.toString() + "/" + res.matchDate.year.toString();
        return matchDate.match(this.dateTo);
      });
    }
  }
}
