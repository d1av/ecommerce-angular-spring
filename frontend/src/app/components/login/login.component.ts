import { isPlatformBrowser } from '@angular/common';
import { Component, Inject, Injector, OnInit, PLATFORM_ID } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthInterceptorService } from 'src/app/services/authentication/auth-interceptor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isSignIn: any;
  loginFormGroup!: FormGroup;
  isDisabled: boolean = true;

  constructor (
    @Inject(PLATFORM_ID) public platformId: object,
    private formBuilder: FormBuilder,
    private injector: Injector,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.loginFormGroup = this.formBuilder.group({
      email: new FormControl('', [Validators.required,
      Validators.email, Validators.minLength(4)]),
      password: new FormControl('', [Validators.minLength(4),
      Validators.maxLength(16), Validators.required])
    });
    this.loginFormGroup.valueChanges.subscribe(() => {
      if (this.loginFormGroup.invalid) {
        this.isDisabled = true;
      } else {
        this.isDisabled = false;
      }
    });
  }

  handleSubmit() {
    if (this.loginFormGroup.invalid) {
      this.loginFormGroup.markAllAsTouched();
      return;
    }
    const formForApi = {
      usernameOrEmail: this.loginFormGroup.value['email'],
      password: this.loginFormGroup.value['password']
    };
    const authService = this.injector.get(AuthInterceptorService);
    authService.login(formForApi).subscribe(
      data => {
        if (data) {
          console.log(data);
          this.router.navigateByUrl('/admin');
          if (isPlatformBrowser(this.platformId)) {
            localStorage.setItem('token', data.accessToken);
          }
        }
      }
    );

  }

  get email() { return this.loginFormGroup.get('email'); }
  get password() { return this.loginFormGroup.get('password'); }

}
