import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import {FilmsModule} from './films/films.module';
import {NavbarComponent} from './navbar/navbar.component';
import {RouterModule} from '@angular/router';
import {navbarRoute} from './navbar/navbar.route';
import {CinemaModule} from './cinema/cinema.module';
import {HomeModule} from './home/home.module';
import { AccountModule } from './account/account.module';
const ENTITY_STATE = [...navbarRoute];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent
  ],
  imports: [
  BrowserModule,
    RouterModule.forRoot(ENTITY_STATE),
    NgbModule,
    FormsModule,
    HttpClientModule,
    FilmsModule,
    CinemaModule,
    HomeModule,
    AccountModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
