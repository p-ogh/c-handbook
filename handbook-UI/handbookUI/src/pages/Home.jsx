import Header from '../components/Header.jsx'
import Dashboard from '../components/Dashboard.jsx'
import Footer from '../components/Footer.jsx'
import Sidebar from '../components/Sidebar.jsx'



function Home(){
    return(
        <>
            <Header/>
            <div className='app-main'>
                <Sidebar/>
                <Dashboard/>
            </div>
            <Footer/>
        </>
        )

    }

export default Home