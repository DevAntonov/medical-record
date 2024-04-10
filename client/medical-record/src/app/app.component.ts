import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Admin } from './model/admin';
import { AdminService } from './service/admin.service';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  public admins!: Admin[];
  
  constructor(private adminService: AdminService) {}

  ngOnInit()
  {
    this.getAdmins();
  }

  public getAdmins(): void
  {
    this.adminService.getAdmins().subscribe(
      (response: Admin[]) => {
        this.admins = response
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onAddAdmin(addForm: NgForm): void
  {
    document.getElementById('add-admin-form')?.click();
    this.adminService.addAdmin(addForm.value).subscribe(
      (response: Admin) => {
        console.log(response);
        this.getAdmins();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  public onOpenModal(admin: Admin | null, mode: string): void
  {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add')
    {
      button.setAttribute('data-target', '#addAdminModal');
    }

    container?.appendChild(button);
    button.click();
  }
}
