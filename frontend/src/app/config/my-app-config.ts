import { environment } from "src/environments/environment";

export default {
  oidc: {
    clientId: '0oa7slv4ogJuueesy5d7',
    issuer: 'https://dev-86276196.okta.com/oauth2/default',
    redirectUri: environment.shopApiUrl + '/login/callback',
    scopes: ['openid', 'profile', 'email']
  }
}
