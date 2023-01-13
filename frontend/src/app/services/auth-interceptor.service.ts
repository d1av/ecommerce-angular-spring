import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, lastValueFrom, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import Login from '../common/login';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  baseUrl = environment.shopApiUrl;

  constructor(
    private http: HttpClient,
  ) { }


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleAccess(request, next));
  }

  private async handleAccess(request: HttpRequest<any>, next: HttpHandler): Promise<HttpEvent<any>> {
    const theEndpoint = environment.shopApiUrl

    const securedEndpoints = [theEndpoint];

    if (securedEndpoints.some(url => request.urlWithParams.includes(url))) {

      // request = request.clone({
      //   setHeaders: {
      //     Authorization: 'Bearer ' + accessToken
      //   }
      // });
    }
    return await lastValueFrom(next.handle(request));
  }

  login(formValue: Login): Observable<any> {
    return this.http.post<Login>(this.baseUrl+'/api/auth/login', formValue)
  }
}
