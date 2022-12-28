import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Product } from '../common/product';
import { map, Observable } from 'rxjs';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/products';
  private categoryUrl = 'http://localhost:8080/product-categories';
  private searchUrl = 'http://localhost:8080/products/search'

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/search/category?id=${theCategoryId}`;
    return this.getProducts(searchUrl)
  }

  getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<ApiResponseProduct>(searchUrl)
      .pipe(map(response => response.content));
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<ResponseProductCategory>(this.categoryUrl)
      .pipe(map(response => response.content));

  }

  searchProducts(theKeyword: string | null): Observable<Product[]> {
    const searchUrl = `${this.searchUrl}?name=${theKeyword}`;
    console.log(searchUrl)
    return this.getProducts(searchUrl)
  }
}

interface ApiResponseProduct {
  content: Product[]
}

interface ResponseProductCategory {
  content: ProductCategory[]
}
