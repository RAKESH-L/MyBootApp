import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './model/employee.model';
import { Student } from './model/student.model';
import { EmployeeService } from './service/employee.service';
import { StudentService } from './service/student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit, OnDestroy{

  empArr: Employee[] = [];
  studentArr : Student[] = [];
  employee:Employee;
  constructor(private employeeService: EmployeeService,
      private studentservice: StudentService){ } //injecting ES

  ngOnInit():  void{
    this.employeeService.getAllEmployee().subscribe(data=>{
      this.empArr = data;
    });

    this.studentservice.getAllStudent().subscribe(data=>{
      this.studentArr = data;
    });
  }

  deleteEmployee(eid: number){
    this.employeeService.deleteEmployee(eid).subscribe(
      data=>{
        this.empArr = this.empArr.filter(e=>e.id != eid);
      }
      );
  }
  onEmployeeSubmit(employeeForm:NgForm){
    // console.log(employeeForm.value.name);
    // console.log(employeeForm.value.city);
    // console.log(employeeForm.value.salary);
    // console.log(employeeForm.value.startDate);
    // console.log(employeeForm.value.startTime);
    this.employee={
      name: employeeForm.value.name,
      city: employeeForm.value.city,
      salary: employeeForm.value.salary
    }
    this.employeeService.postEmployee(this.employee).subscribe(data=>{
      this.empArr.push(data);
    });

    employeeForm.reset();
  }

  ngOnDestroy(): void{
    console.log('on destroy...');
  }

  // e1:Employee;
  // e2:Employee;
  // e3:Employee;
  // employeeArr:Employee[]=[];

  // constructor(){ }

  // ngOnInit():  void{
  //   this.e1={
  //     id:1,
  //     name:'Rakesh L',
  //     city:'Tumkur',
  //     salary:1200000
  //   };
  //   this.e2={
  //     id:2,
  //     name:'Lokesh NS',
  //     city:'Bangalore',
  //     salary:75000
  //   };
  //   this.e3={
  //     id:3,
  //     name:'Bharathi B',
  //     city:'Mysore',
  //     salary:95000
  //   };

  //   this.employeeArr.push(this.e1);
  //   this.employeeArr.push(this.e2);
  //   this.employeeArr.push(this.e3);

  // }
  // ngOnDestroy(): void{
  //   console.log('on destroy...');
  // }



  // e1:Employee={
  //   id:1,
  //   name:'Rakesh L',
  //   city:'Tumkur',
  //   salary:85000
  // };
  // e2:Employee={
  //   id:2,
  //   name:'Lokesh NS',
  //   city:'Bangalore',
  //   salary:75000
  // };
  // e3:Employee={
  //   id:3,
  //   name:'Bharathi B',
  //   city:'Mysore',
  //   salary:95000
  // };
  // employeeArr:Employee[]=[this.e1,this.e2,this.e3];



  // cities:string[] = ['Tumkur','Bangalore','Mysore'];
  // values:number[] = [1,4,2,35,7,985,334,23]


  // status: boolean = false;

  // toggleContact(){
  //   this.status = !this.status;
  // }


  // x:number=20;
  // y:number=10;
  // ans:number=0;

  // add(){
  //   this.ans = this.x + this.y;
  // }
  // sub(){
  //   this.ans = this.x - this.y;
  // }
  // mul(){
  //   this.ans = this.x * this.y;
  // }
  // div(){
  //   this.ans = this.x / this.y;
  // }
}
