import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageHeaderModule } from '../../shared';
import { UserManagementRoutingModule } from './user-management-routing.module';
import { UserManagementComponent } from './user-management.component';
import { DataTablesModule } from 'angular-datatables';

@NgModule({
    imports: [CommonModule, UserManagementRoutingModule, PageHeaderModule,DataTablesModule],
    declarations: [UserManagementComponent]
})
export class UserManagementModule {}
