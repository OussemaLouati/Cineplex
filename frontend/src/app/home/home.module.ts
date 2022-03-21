import {NgModule} from '@angular/core';
import {HomeComponent} from './home.component';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {homeRoutes} from './home.routes';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HomeService} from './home.service';

const routes = [...homeRoutes];
@NgModule({
  imports: [CommonModule, HttpClientModule, NgbModule, RouterModule.forRoot(routes)],
  declarations: [HomeComponent],
  entryComponents: [],
  exports: [],
  providers: [HomeService]
})
export class HomeModule {}
