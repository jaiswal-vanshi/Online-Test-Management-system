import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddexamComponent } from './addexam/addexam.component';
import { AssignexamComponent } from './assignexam/assignexam.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ViewassignexamComponent } from './viewassignexam/viewassignexam.component';
import { ViewexamComponent } from './viewexam/viewexam.component';

@NgModule({
  declarations: [
    AppComponent,
    AddexamComponent,
    AssignexamComponent,
    ViewassignexamComponent,
    ViewexamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
