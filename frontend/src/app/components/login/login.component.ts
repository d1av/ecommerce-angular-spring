import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

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
    private formBuilder: FormBuilder
  ) {

  }

  ngOnInit(): void {
    this.loginFormGroup = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email, Validators.minLength(4)]),
      password: new FormControl('', [Validators.minLength(4), Validators.maxLength(16), Validators.required])

    })
    this.loginFormGroup.valueChanges.subscribe(changes => {
      if (this.loginFormGroup.invalid) {
        this.isDisabled = true;
      } else {
        this.isDisabled = false;
      }
      console.log(changes);

    });
  }

  handleSubmit() {
    console.log(this.loginFormGroup.value);
    if (this.loginFormGroup.invalid) {
      this.loginFormGroup.markAllAsTouched();
      return;
    }

  }

  get email() { return this.loginFormGroup.get('email') }
  get password() { return this.loginFormGroup.get('password') }

}
