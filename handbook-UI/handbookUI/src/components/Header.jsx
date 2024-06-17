import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHouseUser } from '@fortawesome/free-solid-svg-icons'
import Button from 'react-bootstrap/Button';
import { faBars } from '@fortawesome/free-solid-svg-icons'





function Header(){

    return(
        <Navbar className="header-shadow" bg="light" data-bs-theme="light" style={{padding:20, display:'flex', }}>
                <Navbar.Toggle />

                <div className="app-header">
                    <Navbar.Brand href="/">The Coaches Handbook</Navbar.Brand>
                    <div className="hamburger_outer ml-auto">
{/*                             <button type="button" className="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar"> */}
{/*                                 <FontAwesomeIcon icon={faBars}/> */}
{/*                             </button> */}
                            <Button className="hamburger close-sidebar-btn hamburger--elastic" variant="light" type="button"><FontAwesomeIcon icon={faBars} /></Button>

                    </div>
                </div>

                  <Navbar.Collapse className="justify-content-end">
                                    <Navbar.Text>
                                       <Link to={`/`}><FontAwesomeIcon icon={faHouseUser} />{" "}Dashboard</Link>
                                    </Navbar.Text>
                  </Navbar.Collapse>
        </Navbar>
    )
}

export default Header


