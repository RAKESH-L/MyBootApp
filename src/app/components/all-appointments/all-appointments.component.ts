import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/model/appointment.model';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-all-appointments',
  templateUrl: './all-appointments.component.html',
  styleUrls: ['./all-appointments.component.css']
})
export class AllAppointmentsComponent implements OnInit {

  appointmentArry: Appointment[];
  constructor(private appointmentService: AppointmentService) { }

  ngOnInit(): void {
    this.appointmentService.getAllAppointment().subscribe(data=>{
      this.appointmentArry = data;
    });
  }
}
