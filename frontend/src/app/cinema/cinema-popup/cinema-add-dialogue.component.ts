import {Component, OnDestroy, OnInit, Input} from '@angular/core';
import {ICinema} from '../../models/cinema.interface';
import {CinemaService} from '../cinema.service';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpResponse} from '@angular/common/http';
import { DataSharingService } from '../../shared/data-sharing.service';

@Component({
  selector: 'app-cinema-popup',
  templateUrl: 'cinema-add-dialogue.component.html'
})
export class CinemaAddDialogueComponent implements OnInit, OnDestroy {
  @Input()
  cinema: ICinema;
  constructor(private cinemaService: CinemaService, private activeModal: NgbActiveModal, private dataSharingService: DataSharingService) {}
  ngOnDestroy(): void {
  }
  dismiss() {
    this.activeModal.dismiss('close');
  }
  save() {
    this.cinemaService.addCinema(this.cinema).subscribe((cinema: HttpResponse<ICinema>) => {
      this.dataSharingService.emitCinemaAdded(true);
      this.activeModal.dismiss('Added cinema');
    });
  }
  ngOnInit(): void {
    if (!this.cinema) {
      this.cinema = {};
    }
  }
}
