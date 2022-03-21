import {Component, OnInit, OnDestroy} from '@angular/core';
import {HomeService} from './home.service';
import {ICinema} from '../models/cinema.interface';
import {HttpResponse} from '@angular/common/http';
import {IShowingDetails} from '../models/showing-details.interface';

@Component({
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  governorate: string[] = ['Sousse', 'Tunis', 'Hammamet'];
  cinemas: ICinema[];
  showingDetails: IShowingDetails[];
  constructor(private homeService: HomeService) {}
  ngOnDestroy(): void {
  }
  displayCinemas(event) {
    this.homeService.getAllCinemasByGouvernorat(event).subscribe((response: HttpResponse<ICinema[]>) => {
      this.cinemas = response.body;
    });
  }

  displayShowingDetails(event) {
    this.homeService.getCinemaById(event).subscribe((cinema: HttpResponse<ICinema>) => {
      this.homeService.getProgrammeByCinema(cinema.body).subscribe((showingDetails: HttpResponse<IShowingDetails[]>) => {
          this.showingDetails = showingDetails.body;
      });
    });
  }
  ngOnInit(): void {
  }

}
