import {Component, OnInit, OnDestroy} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {CinemaAddDialogueComponent} from './cinema-popup/cinema-add-dialogue.component';
import {ICinema} from '../models/cinema.interface';
import {CinemaService} from './cinema.service';
import {HttpResponse} from '@angular/common/http';
import {ShowingDetailPopupComponent} from './cinema-popup/showing-detail-popup.component';
import { CinemaDeletePopupComponent } from './cinema-popup/cinema-delete-popup.component';
import { Subscription } from 'rxjs';
import { DataSharingService } from '../shared/data-sharing.service';

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit, OnDestroy {
  cinemas: ICinema[];
  subscription: Subscription;
  constructor(private modal: NgbModal, private cinemaService: CinemaService, private dataSharingService: DataSharingService) {
    this.subscription = this.dataSharingService.getCinemaAddedObservable().subscribe((value: boolean) => {
        if (value) {
          this.cinemaService.getAllCinemas().subscribe((cinemas: HttpResponse<ICinema[]>) => {
            this.cinemas = cinemas.body;
          });
        }
    });
  }

  addCinema() {
    this.modal.open(CinemaAddDialogueComponent, {
      size: 'lg',
      backdrop: 'static'
    });
  }

  ngOnDestroy(): void {
  }
  deleteCinema(cinema) {
    const modal = this.modal.open(CinemaDeletePopupComponent, {
      size: 'lg',
      backdrop: 'static'
    });
    modal.componentInstance.cinema = cinema;
  }
  updateCinema(cinema) {
    const modal = this.modal.open(CinemaAddDialogueComponent, {
      size: 'lg',
      backdrop: 'static'
    });
    modal.componentInstance.cinema = cinema;
  }
  addShowingDetail(cinema: ICinema) {
    const modalComponent = this.modal.open(ShowingDetailPopupComponent, {
      size: 'lg',
      backdrop: 'static'
    });
    modalComponent.componentInstance.cinema = cinema;
  }
  ngOnInit(): void {
    this.cinemaService.getAllCinemas().subscribe((cinemas: HttpResponse<ICinema[]>) => {
      this.cinemas = cinemas.body;
    });
  }
}
