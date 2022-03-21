import {Component, Input} from '@angular/core';
import { ICinema } from 'src/app/models/cinema.interface';
import { CinemaService } from '../cinema.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { DataSharingService } from '../../shared/data-sharing.service';
import { HttpResponse } from '@angular/common/http';
import { IDeleteDTOInterface } from 'src/app/models/deleteDTO.interface';
@Component({
    selector: 'app-delete-popup',
    templateUrl: './cinema-delete-popup.component.html'
})
export class CinemaDeletePopupComponent {
    @Input()
    cinema: ICinema;
    constructor(private cinemaService: CinemaService, private activeModal: NgbActiveModal, private dataSharingService: DataSharingService) {
    }
    delete() {
        this.cinemaService.deleteCinema(this.cinema.id).subscribe((res: HttpResponse<IDeleteDTOInterface>) => {
            this.dataSharingService.emitCinemaAdded(true);
            this.activeModal.dismiss('deleted');
        });
    }
}
