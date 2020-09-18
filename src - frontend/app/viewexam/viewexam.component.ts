import { Component, OnInit } from '@angular/core';
import { ExamService } from '../exam.service';
import { Exam } from '../exam';

@Component({
  selector: 'app-viewexam',
  templateUrl: './viewexam.component.html',
  styleUrls: ['./viewexam.component.css']
})
export class ViewexamComponent implements OnInit {
  msg:string;
  errorMsg:string;
  exam:Exam = new Exam();
  exams:Exam[]=[];
  addExamFlag:boolean;
  viewExamFlag:Boolean;

  constructor(private examService:ExamService ) { }
  ngOnInit(): void {
      //View all Exams
      this.examService.viewExams().subscribe(data=>{this.exams=data; this.addExamFlag =false;
      this.viewExamFlag=true;});
      
      
  }

}
