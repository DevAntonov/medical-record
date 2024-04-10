import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) {}


  public getAdmins(): Observable<Admin[]> 
  {
      return this.http.get<Admin[]>(`${this.apiServerUrl}/admins`) 
  }
  
  
  public addAdmin(admin: Admin): Observable<Admin>
  {
      return this.http.post<Admin>(`${this.apiServerUrl}/admins`, admin)
  }
}
