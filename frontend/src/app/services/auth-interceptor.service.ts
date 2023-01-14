import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, lastValueFrom, map, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import Login from '../common/login';
import tokenResponse from '../common/tokenResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  baseUrl = environment.shopApiUrl;
  accessToken: string | undefined;
  responseLoginDataFromApi: any;
  storage: Storage = sessionStorage;

  constructor(
    private http: HttpClient,
  ) { }


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleAccess(request, next));
  }

  private async handleAccess(request: HttpRequest<any>, next: HttpHandler): Promise<HttpEvent<any>> {
    const theEndpoint = environment.shopApiUrl + '/orders'

    const securedEndpoints = [theEndpoint];
    if (this.accessToken == null) {
      this.accessToken = localStorage.getItem("token")!;
    }

    if (securedEndpoints.some(url => request.urlWithParams.includes(url))) {

      request = request.clone({
        setHeaders: {
          Authorization: 'Bearer ' + this.accessToken
        }
      });
    }
    return await lastValueFrom(next.handle(request));
  }


  login(formValue: Login): Observable<any> {
    return this.http.post<tokenResponse>(this.baseUrl + '/api/auth/login', formValue).pipe(map(
      data => {
        this.accessToken = data.accessToken;
        this.storage.setItem("token", data.accessToken)
        this.storage.setItem("email", formValue.usernameOrEmail)
        return this.responseLoginDataFromApi = data;
      })
    )
  }
}
