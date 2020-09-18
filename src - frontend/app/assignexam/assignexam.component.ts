import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ExamService } from '../exam.service';
import { Assign } from '../assign';
import { Assignexam } from '../assignexam';
@Component({
  selector: 'app-assignexam',
  templateUrl: './assignexam.component.html',
  styleUrls: ['./assignexam.component.css']
})
export class AssignexamComponent implements OnInit {

  @ViewChild("frm")
form:NgForm;
msg:string;
errorMsg:string;
userId:number;
examId:number;
users:any=[]
exams:any=[];
assignexam:Assignexam=new Assignexam();


  constructor(private examService:ExamService) { }

  ngOnInit(): void {
    this.examService.assignExam(this.assignexam).subscribe(data=>this.assignexam=data);
  }
  //Assign Exam to User
  assignExamToUser(){
    this.examService.assignExam(this.assignexam).subscribe(
     data=>{this.msg= data.message; this.form.resetForm()},
     error=> {this.errorMsg= error.error.message;}
      );
    
   
}


}
