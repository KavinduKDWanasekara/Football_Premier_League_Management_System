import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';


import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { ClubsComponent } from './clubs/clubs.component';
import { MatchesComponent } from './matches/matches.component';
import {MatTableModule} from "@angular/material/table";
import {FormsModule} from "@angular/forms";
import { MatSortModule } from '@angular/material/sort';

const routes: Routes = [
  {
    path:'',component: ClubsComponent
  },

  {
    path:'match',component: MatchesComponent
  },

  {
    path: '**',
    redirectTo: '/play',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ClubsComponent,
    MatchesComponent
  ],
    imports: [
        BrowserModule,
        MatSortModule,
        HttpClientModule,
        HttpClientXsrfModule.withOptions({
            cookieName: 'Csrf-Token',
            headerName: 'Csrf-Token',
        }),
        RouterModule.forRoot(routes),
        MatTableModule,
        FormsModule
    ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
