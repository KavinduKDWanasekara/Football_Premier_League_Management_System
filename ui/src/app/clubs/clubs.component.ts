import { AfterViewInit, Component, ViewChild, } from '@angular/core';
import { IService } from '../types/service.type';
import { MatTableDataSource } from '@angular/material/table';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.css']
})
export class ClubsComponent implements AfterViewInit {

  clubName: string;

  ELEMENT_DATA: any;
  displayedColumns: string[] = ['clubName', 'location', 'ToPoints',  'numOfWins', 'numOfDefeats', 'numOfDraws', 'numOfGoalsReceived', 'numOfGoalsScored', 'numberOfMatches', 'goalDifferrence'];
  dataSource = new  MatTableDataSource<IService>();

  constructor(private Serviceservice:ServicesService) {
  }
  ngAfterViewInit(): void {
    this.ELEMENT_DATA = new MatTableDataSource(this.ELEMENT_DATA)
    this.getAllService();
  }

 public getAllService() {
   this.ELEMENT_DATA = [];
   this.dataSource = new MatTableDataSource([]);
   let response = this.Serviceservice.getAllService();
   response.subscribe(report=>this.dataSource.data=report as IService[])
  
 }



}
