import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CinemaComponent} from './cinema.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {cinemaRoutes} from './cinema.routes';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CinemaAddDialogueComponent} from './cinema-popup/cinema-add-dialogue.component';
import {HttpClientModule} from '@angular/common/http';
import {CinemaService} from './cinema.service';
import {ShowingDetailPopupComponent} from './cinema-popup/showing-detail-popup.component';
import { CinemaDeletePopupComponent } from './cinema-popup/cinema-delete-popup.component';
const routes = [...cinemaRoutes];
@NgModule({
  imports: [CommonModule, FormsModule, NgbModule, HttpClientModule, RouterModule.forRoot(routes)],
declarations: [CinemaComponent, CinemaAddDialogueComponent, ShowingDetailPopupComponent, CinemaDeletePopupComponent],
  entryComponents: [CinemaAddDialogueComponent, ShowingDetailPopupComponent, CinemaDeletePopupComponent],
  providers: [CinemaService]
})
export class CinemaModule {}
