import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 1;
  searchMode: boolean = false;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    })
  }


  listProducts() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword')
    if (this.searchMode) {
      this.handleSearchProducts();
    } else {
      this.handleListProducts();
    }
  }


  handleSearchProducts() {
    const theKeyword: string  = this.route.snapshot.paramMap.get('keyword')!

    this.productService.searchProducts(theKeyword).subscribe(
      (data: any) => {
        console.log(data)
        this.products = data;
      }
    )
  }

  handleListProducts() {
    const routeHasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if (routeHasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
    } else {
      this.currentCategoryId = 1
    }

    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }

}
