import {Component, OnInit, OnDestroy} from '@angular/core';
import {IFilm} from '../../models/film.interface';
import {FilmsService} from '../films.service';
import {DataSharingService} from '../../shared/data-sharing.service';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-film-popup-add',
  templateUrl: './film-popup-add.component.html'
})
export class FilmPopupAddComponent implements OnInit, OnDestroy {
  film: IFilm;

  constructor(private filmService: FilmsService, private dataService: DataSharingService, private activeModal: NgbActiveModal) {
  }

  ngOnDestroy(): void {
  }

  dismiss() {
    this.activeModal.dismiss('closed');
  }

  save() {
    this.filmService.addMovie(this.film).subscribe((film: HttpResponse<IFilm>) => {
      this.dataService.emitFilmAdded(true);
      this.dismiss();
    });
  }

  ngOnInit(): void {
    this.film = {};
  }

}
