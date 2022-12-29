import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Country } from 'src/app/common/country';
import { State } from 'src/app/common/state';
import { ShopFormService } from 'src/app/services/shop-form.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {

  checkoutFormGroup!: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;

  creditCardYears: number[] = [];
  creditCardMonths: number[] = [];

  countries: Country[] = [];
  states: State[] = [];

  shippingAddressStates: State[]=[];
  billingAddressStates: State[]=[];

  constructor(private formBuilder: FormBuilder,
    private shopFormService: ShopFormService) {

  }
  ngOnInit(): void {
    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: [''],
        lastName: [''],
        email: ['']
      }),
      shippingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: ['']
      }),
      billingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: ['']
      }),
      creditCard: this.formBuilder.group({
        cardType: [''],
        nameOnCard: [''],
        cardNumber: [''],
        securityCode: [''],
        expirationMonth: [''],
        expirationYear: ['']
      })
    })

    //populate credit card month and year
    const startMonth: number = new Date().getMonth() + 1;
    console.log("StartMonth: " + startMonth);

    this.shopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Retrieved credit card years: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    )

    this.shopFormService.getCreditCardYear().subscribe(
      data => {
        console.log("Retrieved credit card years: " + data)
        this.creditCardYears = data;
      }
    );

    //populate countries

    this.shopFormService.getCountries().subscribe(
      data => {
        console.log("Retrieved countries " + JSON.stringify(data));
        this.countries = data;
      }
    )

    //populate states




  }

  onSubmit() {
    console.log(this.checkoutFormGroup.get('customer')?.value)
    console.log(this.checkoutFormGroup.get('shippingAddress')?.value)
    console.log(this.checkoutFormGroup.get('billingAddress')?.value)
    console.log(this.checkoutFormGroup.get('creditCard')?.value)
  }

  copyShippingAddressToBillingAddress(event: any) {
    if (event.target.checked) {
      this.checkoutFormGroup.controls['billingAddress']
        .setValue(this.checkoutFormGroup.controls['shippingAddress'].value)
    } else {
      this.checkoutFormGroup.controls['billingAddress'].reset()
    }
  }

  handleMonthsAndYears() {
    const creditCardFormGroup = this.checkoutFormGroup.get('creditCard');

    const currentYear: number = new Date().getFullYear();
    const selectedYear: number = Number(creditCardFormGroup?.value.expirationYear);

    let startMonth: number;

    if (currentYear === selectedYear) {
      startMonth = new Date().getMonth() + 1;
    } else {
      startMonth = 1
    }

    this.shopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Retrieved credit card months: " + data)
        this.creditCardMonths = data;
      }
    )
  }

  getStates(formGroupName: string) {
    const formGroup = this.checkoutFormGroup.get(formGroupName);

    const countryCode = formGroup?.value.country.code
    const countryName = formGroup?.value.country.name

    console.log(`{formGroupName} country code: ${countryCode}`);
    console.log(`{formGroupName} country name: ${countryName}`);

    this.shopFormService.getStates(countryCode).subscribe(
      data=>{
        if(formGroupName==='shippingAddress'){

        }
      }
    )

  }
}
