import {Component, Input, OnInit, OnDestroy} from '@angular/core';
import {IFilm} from '../../models/film.interface';
import {FilmsService} from '../films.service';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpResponse} from '@angular/common/http';
import {DataSharingService} from '../../shared/data-sharing.service';

@Component({
  selector: 'app-film-popup',
  templateUrl: './film-popup.component.html'
})
export class FilmPopupComponent implements OnInit, OnDestroy {
  @Input()
  film: IFilm;

  constructor(private filmService: FilmsService, private activeModal: NgbActiveModal, private dataService: DataSharingService) {
  }

  ngOnDestroy(): void {
  }

  dismiss() {
    this.activeModal.dismiss('closed');
  }

  save() {
    this.filmService.updateMovie(this.film.id, this.film).subscribe((filmResponse: HttpResponse<IFilm>) => {
      this.dataService.emitFilmUpdated(true);
      this.dismiss();
    });
  }

  ngOnInit(): void {

  }
}
