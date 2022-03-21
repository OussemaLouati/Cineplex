import {Component, OnInit, OnDestroy} from '@angular/core';
import {FilmsService} from './films.service';
import {IFilm} from '../models/film.interface';
import {HttpResponse} from '@angular/common/http';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FilmPopupComponent} from './film-popup/film-popup.component';
import {FilmPopupDeleteComponent} from './film-popup/film-popup-delete.component';
import {Subscription} from 'rxjs';
import {DataSharingService} from '../shared/data-sharing.service';
import {FilmPopupAddComponent} from './film-popup/film-popup-add.component';

@Component({
  selector: 'app-films-component',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})

export class FilmsComponent implements OnInit, OnDestroy {
  films: IFilm[];
  deletedSubscription: Subscription;
  updatedSubscription: Subscription;
  addedSubscription: Subscription;
  updated = false;
  deleted = false;
  added = false;
  constructor(private filmService: FilmsService, private modal: NgbModal, private dataService: DataSharingService) {
    this.updatedSubscription = this.dataService.getUpdatedObservable().subscribe((value: boolean) => {
      if (value) {
        this.loadAllFilms();
        this.updated = true;
        setTimeout(() => {
          this.updated = false;
        }, 3000);
      }
    });

    this.deletedSubscription = this.dataService.getDeletedObservable().subscribe((value: boolean) => {
      if (value) {
        this.loadAllFilms();
        this.deleted = true;
        setTimeout(() => {
          this.deleted = false;
        }, 3000);
      }
    });

    this.addedSubscription = this.dataService.getAddedObservable().subscribe((value: boolean) => {
      if (value) {
        this.loadAllFilms();
        this.added = true;
        setTimeout(() => {
          this.added = false;
        }, 3000);
      }
    });
  }

  ngOnDestroy(): void {
    this.deletedSubscription.unsubscribe();
    this.updatedSubscription.unsubscribe();
  }

  loadAllFilms(): void {
    this.filmService.getAllFilms().subscribe((filmsResponse: HttpResponse<IFilm[]>) => {
      this.films = filmsResponse.body;
    });
  }
  addMovie() {
    const modal = this.modal.open(FilmPopupAddComponent, {
      size: 'lg',
      backdrop: 'static'
    });
  }
  deleteFilm(film): void {
    const modal = this.modal.open(FilmPopupDeleteComponent, {
      size: 'lg',
      backdrop: 'static'
    });
    modal.componentInstance.film = film;
  }

  updateFilm(film: IFilm): void {
    const modal = this.modal.open(FilmPopupComponent, {
      size: 'lg',
      backdrop: 'static'
    });
    modal.componentInstance.film = film;
  }

  ngOnInit(): void {
    this.loadAllFilms();
  }
}
