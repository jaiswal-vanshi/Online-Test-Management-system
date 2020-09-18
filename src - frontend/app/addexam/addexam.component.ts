import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Exam } from '../exam';
import { User } from '../user';
import { ExamService } from '../exam.service';
@Component({
  selector: 'app-addexam',
  templateUrl: './addexam.component.html',
  styleUrls: ['./addexam.component.css']
})
export class AddexamComponent implements OnInit {
  @ViewChild("examfrm")
  examfrm:NgForm;
  msg:string;
  errorMsg:string;
  exam:Exam = new Exam();
  exams:Exam[]=[];
  addExamFlag:boolean;
  viewExamFlag:Boolean;


  constructor(public examService:ExamService) { }

  ngOnInit(): void {
  }
  //Add Exam
  addExam(){
    this.examService.addExam(this.exam).subscribe(data=>{this.msg = data.message;
    this.examfrm.resetForm() },
    error=>this.errorMsg= error.error.message);
    }
    
    showAddExam(){ this.addExamFlag =true; this.viewExamFlag=false;}
    

}
