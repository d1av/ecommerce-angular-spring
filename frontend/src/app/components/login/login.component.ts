import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isSignIn: any;
  loginFormComponent!: FormGroup;

  constructor(
    private formBuilder: FormBuilder
  ) {

  }
  ngOnInit(): void {
    this.loginFormComponent = this.formBuilder.group({
      email: [''],
      password: ['']
    })
  }

  handleSubmit(){
    console.log(this.loginFormComponent.value);

  }

}
