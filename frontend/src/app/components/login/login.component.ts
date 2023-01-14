import { Component, Injector, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthInterceptorService } from 'src/app/services/auth-interceptor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isSignIn: any;
  loginFormGroup!: FormGroup;
  isDisabled: boolean = true;

  constructor(
    private formBuilder: FormBuilder,
    private injector: Injector
  ) {

  }

  ngOnInit(): void {
    this.loginFormGroup = this.formBuilder.group({
      email: new FormControl('', [Validators.required,
      Validators.email, Validators.minLength(4)]),
      password: new FormControl('', [Validators.minLength(4),
      Validators.maxLength(16), Validators.required])
    })
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
    }
    const authService = this.injector.get(AuthInterceptorService);
    authService.login(formForApi).subscribe(
      data => console.log(data)
    )

  }

  get email() { return this.loginFormGroup.get('email') }
  get password() { return this.loginFormGroup.get('password') }

}
