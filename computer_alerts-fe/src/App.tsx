import './App.css';
// import { RouterProvider } from 'react-router-dom';
// import router from './router';
// import ReaderList from './ReaderList';
import Login from './Login'
import LogoutButton from './Logout';


function App(): JSX.Element {

  return(
    <div>
      <h1>Hello</h1>
      {/* <ReaderList/> */}
      <Login/>
    </div>
    
  ); ;
  // return <RouterProvider router={router} />;
}

export default App;