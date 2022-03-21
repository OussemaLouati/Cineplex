import { NgModule } from '@angular/core';
import { AccountLoginComponent } from './account-login/account-login.component';
import { AccountSignupComponent } from './account-signup/account-signup.component';
import { RouterModule } from '@angular/router';
import { loginRoute } from './account-login/account-login.route';

const routes = [...loginRoute];
@NgModule({
    declarations: [AccountLoginComponent, AccountSignupComponent],
    imports: [RouterModule.forRoot(routes)],
entryComponents: [AccountSignupComponent, AccountLoginComponent],
    providers: []
})
export class AccountModule {}
