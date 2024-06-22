import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListEmployeeComponent from './Component/ListEmployeeComponent'
import HeaderComponent from './Component/HeaderComponent'
import FooterComponent from './Component/FooterComponent'
import EmployeeComponent from './Component/EmployeeComponent'
import {BrowserRouter,Routes,Route} from 'react-router-dom'





function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    <HeaderComponent />
    <Routes>
      <Route path='/' element = {<ListEmployeeComponent />}></Route>
      <Route path='/employees' element = {<ListEmployeeComponent />}></Route>
      <Route path= '/add-employee' element={<EmployeeComponent />} ></Route>

      <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>


    
    
    </Routes>
    <FooterComponent />

   </BrowserRouter>

    </>
  )
}

export default App


// import { useState } from 'react';
// import './App.css';
// import ListEmployeeComponent from './Component/ListEmployeeComponent';
// import HeaderComponent from './Component/HeaderComponent';
// import FooterComponent from './Component/FooterComponent';
// import EmployeeComponent from './Component/EmployeeComponent';
// import { BrowserRouter, Routes, Route } from 'react-router-dom';

// function App() {
//   const [count, setCount] = useState(0);

//   return (
//     <>
//       <BrowserRouter>
//         <HeaderComponent />
//         <Routes>
//           <Route path='/' element={<ListEmployeeComponent />} />
//           <Route path='/employees' element={<ListEmployeeComponent />} />
//           <Route path='/add-employee' element={<EmployeeComponent />} />
//           <Route path='/edit-employee/:id' element={<EmployeeComponent />} />
//         </Routes>
//         <FooterComponent />
//       </BrowserRouter>
//     </>
//   );
// }

// export default App;
