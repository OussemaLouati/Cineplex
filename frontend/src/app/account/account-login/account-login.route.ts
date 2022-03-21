import { Routes } from '@angular/router';
import { AccountLoginComponent } from './account-login.component';

export const loginRoute: Routes = [
    {
        path: 'account',
        component: AccountLoginComponent
    }
];