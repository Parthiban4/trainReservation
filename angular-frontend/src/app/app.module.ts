import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule, FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TrainComponent } from './home/train/train.component';
import { RouterModule, Routes } from '@angular/router';
// import { CheckAvailabilityComponent } from './check-availability/check-availability.component';
import { BookingComponent } from './booking/booking.component';
import { AdminComponent } from './admin/admin.component';
import { PassengerComponent } from './admin/passenger/passenger.component';
import { AddTrainComponent } from './admin/add-train/add-train.component';
import { TrainRoutesComponent } from './admin/train-routes/train-routes.component';
import { CancelTicketComponent } from './home/cancel-ticket/cancel-ticket.component';
import { BookingDetailsComponent } from './admin/booking-details/booking-details.component';
import { BookingResultComponent } from './booking-result/booking-result.component';
import { authGuard } from './auth.guard';
const routes: Routes = [
  { path: "", component: LoginComponent},
  {path : "home", component:HomeComponent, canActivate: [authGuard]},
  { path: "login", component: LoginComponent }, 
  { path: "signup", component: SignupComponent },
  { path: "home/train/:source/:destination/:classes/:date", component: TrainComponent},
  { path: "train", component: TrainComponent, canActivate: [authGuard]},
  {path: "booking", component: BookingComponent, canActivate: [authGuard]},
  {path :"admin", component : AdminComponent, canActivate: [authGuard]},
  {path:"addtrain", component : AddTrainComponent, canActivate: [authGuard]},
  {path: "home/cancelBooking", component : CancelTicketComponent, canActivate: [authGuard]},
  {path: "cancelBooking/home", component: HomeComponent, canActivate: [authGuard]},
  {path: "login/signup", component : SignupComponent},
  {path: "signup/login", component : LoginComponent},
  {path: "home/train/:source/:destination/:classes/:date/booking/:trainId", component : BookingComponent,},
  {path: "admin/manageTrain", component : AddTrainComponent, canActivate: [authGuard]},
  {path: "admin/passengerDetails", component:PassengerComponent},
  {path: "admin/manageRoutes", component : TrainRoutesComponent},
  {path: "admin/bookingDetails",component : BookingDetailsComponent },
  {path: "train/booking/booking", component : BookingComponent},
  {path: "home/train/:source/:destination/:classes/:date/booking/:trainId/bookingResult", component : BookingResultComponent},

];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    TrainComponent,
    // CheckAvailabilityComponent,
    BookingComponent,
    AdminComponent,
    PassengerComponent,
    AddTrainComponent,
    TrainRoutesComponent,
    CancelTicketComponent,
    BookingDetailsComponent,
    BookingResultComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
   // provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
