import Navbar from '../components/Navbar.jsx'
import Footer from '../components/Footer.jsx'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHeart } from '@fortawesome/free-solid-svg-icons'


function TeamDashboard(){
    return(
            <>
                <Navbar/>
                <h2>Dashboard</h2>
                  <div className="container" style={{marginTop:50,}}>
                        <div className="row">
                            <div className="col-md-3">
                                <div className="card-sl">
                                    <div className="card-image">
                                        <img
                                            src="https://images.pexels.com/photos/1149831/pexels-photo-1149831.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" />
                                    </div>

                                    <a className="card-action" href="#"><FontAwesomeIcon icon={faHeart} /></a>

                                    <div className="card-heading">
                                        Audi Q8
                                    </div>
                                    <div className="card-text">
                                        Audi Q8 is a full-size luxury crossover SUV coupé made by Audi that was launched in 2018.
                                    </div>
                                    <div className="card-text">
                                        $67,400
                                    </div>
                                    <a href="#" className="card-button"> Purchase</a>
                                </div>
                            </div>
                        </div>
                  </div>

                <Footer/>
            </>
            )

    }

export default TeamDashboard