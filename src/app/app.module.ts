import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PatientComponent } from './patient/patient.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { PatientAppointmentComponent } from './components/patient-appointment/patient-appointment.component';
import { AllAppointmentsComponent } from './components/all-appointments/all-appointments.component';
import { BookingConfirmationComponent } from './components/booking-confirmation/booking-confirmation.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    NavBarComponent,
    HomeComponent,
    PatientAppointmentComponent,
    AllAppointmentsComponent,
    BookingConfirmationComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
