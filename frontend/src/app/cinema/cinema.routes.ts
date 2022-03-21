import {Routes} from '@angular/router';
import {CinemaComponent} from './cinema.component';

export const cinemaRoutes: Routes = [
  {
    path: 'cinemas',
    component: CinemaComponent,
    children: [

    ]
  }
];
