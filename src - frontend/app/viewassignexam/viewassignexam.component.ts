import { Component, OnInit } from '@angular/core';
import { ExamService } from '../exam.service';
import { Assign } from '../assign';

@Component({
  selector: 'app-viewassignexam',
  templateUrl: './viewassignexam.component.html',
  styleUrls: ['./viewassignexam.component.css']
})
export class ViewassignexamComponent implements OnInit {
  msg:string;
errorMsg:string;
assign:Assign;
assignExamFlag:boolean;
viewassignExamFlag:boolean;


  constructor(private examService:ExamService) { }

  ngOnInit(): void {
    //View all Assigned Exam to User
    this.assign=new Assign();
    this.examService.viewAssignExams().subscribe(data=>{this.assign=data; this.assignExamFlag =false;
      this.viewassignExamFlag=true;});
  }

}
