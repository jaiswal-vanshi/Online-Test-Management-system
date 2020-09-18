import { Component } from '@angular/core';
import { ExamService } from './exam.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[ExamService]
})
export class AppComponent {
  title = 'angularonline';
}
