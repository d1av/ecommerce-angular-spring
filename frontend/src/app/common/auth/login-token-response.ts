export default interface LoginTokenResponse {
  username: string,
  accessToken: string,
  tokenType: string;
  roles: string[];
}
