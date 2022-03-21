import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AccountSignupComponent } from '../account-signup/account-signup.component';
@Component({
  selector: 'app-account-login',
  templateUrl: './account-login.component.html',
  styleUrls: ['./account-login.component.css']
})
export class AccountLoginComponent implements OnInit {

  constructor(private modal: NgbModal, private active: NgbActiveModal) { }

  ngOnInit() {
  }
  signup() {
    this.active.dismiss('closed');
    const modal = this.modal.open(AccountSignupComponent, {
        size: 'lg',
        backdrop: 'static'
    });
    }
}
