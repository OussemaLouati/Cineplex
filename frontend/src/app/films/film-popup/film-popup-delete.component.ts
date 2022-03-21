import {Component, Input, OnInit, OnDestroy} from '@angular/core';
import {FilmsService} from '../films.service';
import {IFilm} from '../../models/film.interface';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpResponse} from '@angular/common/http';
import {IDeleteDTOInterface} from '../../models/deleteDTO.interface';
import {DataSharingService} from '../../shared/data-sharing.service';

@Component({
  selector: 'app-film-delete-popup',
  templateUrl: 'film-popup-delete.component.html'
})
export class FilmPopupDeleteComponent implements OnInit, OnDestroy {
  @Input()
  film: IFilm;

  constructor(private filmService: FilmsService, private activeModal: NgbActiveModal, private dataService: DataSharingService) {
  }

  ngOnDestroy(): void {
  }

  dismiss() {
    this.activeModal.dismiss('cancel');
  }

  delete() {
    this.filmService.deleteMovie(this.film.id).subscribe((response: HttpResponse<IDeleteDTOInterface>) => {
      this.dataService.emitFilmDeleted(true);
      this.dismiss();
    });
  }

  ngOnInit(): void {
  }

}
