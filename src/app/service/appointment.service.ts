import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment.model';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http:HttpClient) { }

  getAllAppointment() : Observable<Appointment[]>{
    return this.http.get<Appointment[]>('http://localhost:2881/appointment/all');
  }
}
