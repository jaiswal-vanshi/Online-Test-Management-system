import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Examconstants } from './examconstants';
import { Exam } from './exam';
import { Observable } from 'rxjs';
import { Assign } from './assign';
import { Assignexam } from './assignexam';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  constructor(private http:HttpClient) { }
    //Add Exam
    public addExam(exam:Exam):Observable<any>{
    return this.http.post("http://localhost:8082/exam/addexam", exam);
    }

    //View all Exams
    public viewExams():Observable<any>{
    return this.http.get("http://localhost:8082/exam/viewexam");
    }

    //View all Assigned Exam to User
    public viewAssignExams():Observable<any>{
      return this.http.get("http://localhost:8082/exam/viewassign");
      }

    //Assign Exam to User
    public assignExam(assignexam:Assignexam):Observable<any>{
      return this.http.post("http://localhost:8082/exam/assignexam",assignexam);
}


}
