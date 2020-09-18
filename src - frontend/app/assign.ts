import { User } from './user';
import { Exam } from './exam';

export class Assign {

    public examUserAssignId: number;
        public marks: number;
        public status: boolean
         public dateOfExam: Date;
         public user:User=new User();
         public exam:Exam=new Exam();
}
