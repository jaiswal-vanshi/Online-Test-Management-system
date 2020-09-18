import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddexamComponent } from './addexam/addexam.component';
import { AssignexamComponent } from './assignexam/assignexam.component';
import { ViewassignexamComponent } from './viewassignexam/viewassignexam.component';
import { ViewexamComponent } from './viewexam/viewexam.component';


const routes: Routes = [
  {path:'addexam',component:AddexamComponent},
  {path:'assignexam',component:AssignexamComponent},
  {path:'viewassignexam',component:ViewassignexamComponent},
  {path:'viewexam', component:ViewexamComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
