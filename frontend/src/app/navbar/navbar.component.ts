import {Component} from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AccountLoginComponent } from '../account/account-login/account-login.component';
@Component({
  selector: 'app-navbar-component',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {
  constructor(private ngbModal: NgbModal) {}
  openLogin() {
    const modal = this.ngbModal.open(AccountLoginComponent, {
        size: 'lg',
        backdrop: 'static'
    });
  }
}
