import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent {


  constructor(
    private router: Router
  ) {
  }

  doSearch(value: string): void {
    console.log(`value=${value}`)
    this.router.navigateByUrl(`/search/${value}`);
  }

}
