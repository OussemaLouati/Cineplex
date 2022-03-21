import {NgModule} from '@angular/core';
import {FilmsComponent} from './films.component';
import {FilmsService} from './films.service';
import {CommonModule} from '@angular/common';
import {FilmPopupComponent} from './film-popup/film-popup.component';
import {FormsModule} from '@angular/forms';
import {FilmPopupDeleteComponent} from './film-popup/film-popup-delete.component';
import {DataSharingService} from '../shared/data-sharing.service';
import {NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import {FilmPopupAddComponent} from './film-popup/film-popup-add.component';
import {filmsRoutes} from './films.routes';
import {RouterModule} from '@angular/router';

const routes = [...filmsRoutes];
@NgModule({
  imports: [CommonModule, FormsModule, NgbAlertModule, RouterModule.forRoot(routes)],
  declarations: [FilmsComponent, FilmPopupComponent, FilmPopupDeleteComponent, FilmPopupAddComponent],
  exports: [FilmsComponent],
  entryComponents: [FilmPopupComponent, FilmPopupDeleteComponent, FilmPopupAddComponent],
  providers: [FilmsService, DataSharingService]
})
export class FilmsModule {}
