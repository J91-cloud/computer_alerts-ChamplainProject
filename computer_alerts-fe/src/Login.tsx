import React, { useState } from 'react';

const Login = () => {
  const [authProvider, setAuthProvider] = useState('');

  const handleLogin = (provider: string) => {
    setAuthProvider(provider);
    // Redirect to the backend's login endpoint for the chosen provider
    const loginUrl = `http://localhost:8080/login/oauth2/authorization/${provider.toLowerCase()}`;
    window.location.href = loginUrl;
  };

  return (
    <div>
      <h1>Login</h1>
      <button onClick={() => handleLogin('Google')}>Login with Google</button>
      <button onClick={() => handleLogin('Facebook')}>Login with Facebook</button>
      <button onClick={() => handleLogin('Auth0')}>Login with Auth0 (Google/Facebook)</button>
    </div>
  );
};

export default Login;

		