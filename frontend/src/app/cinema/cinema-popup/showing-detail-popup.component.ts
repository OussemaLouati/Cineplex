import {Component, Input, OnInit, OnDestroy} from '@angular/core';
import {ICinema} from '../../models/cinema.interface';
import {IShowingDetails} from '../../models/showing-details.interface';
import {FilmsService} from '../../films/films.service';
import {IFilm} from '../../models/film.interface';
import {HttpResponse} from '@angular/common/http';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {CinemaService} from '../cinema.service';

@Component({
  selector: 'app-showing-detail',
  templateUrl: 'showing-detail-popup.component.html',
  providers: [FilmsService, CinemaService]
})
export class ShowingDetailPopupComponent implements OnInit, OnDestroy {
  @Input()
  cinema: ICinema;
  showingDetail: IShowingDetails;
  films: IFilm[];
  constructor(private filmService: FilmsService, private activeModal: NgbActiveModal, private cinemaService: CinemaService) {}

  ngOnDestroy(): void {
  }
  dismiss() {
    this.activeModal.dismiss('closed');
  }
  handleChange(id) {
    this.filmService.getMovieById(id).subscribe((filmResponse: HttpResponse<IFilm>) => {
      this.showingDetail.nomFilm = filmResponse.body.titre;
    });
  }

  save() {
      if (!this.cinema.programme) {
        this.cinema.programme = [];
      }
      console.log(this.showingDetail);
      this.cinema.programme.push(Object.assign({}, this.showingDetail));
      this.cinemaService.updateCinema(this.cinema.id, this.cinema).subscribe((cinemaResponse: HttpResponse<ICinema>) => {
        this.activeModal.dismiss('updated');
      });
  }

  ngOnInit(): void {
    this.showingDetail = {};
    this.filmService.getAllFilms().subscribe((filmsResponse: HttpResponse<IFilm[]>) => {
        this.films = filmsResponse.body;
        this.showingDetail.nomFilm = this.films[0].titre;
    });
    this.showingDetail.places = [];
  }
}
