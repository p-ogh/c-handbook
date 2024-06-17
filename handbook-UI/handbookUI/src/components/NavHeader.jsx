import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHandPointLeft } from '@fortawesome/free-solid-svg-icons'
import Navbar from 'react-bootstrap/Navbar';


function NavHeader(){

    return(
        <Navbar bg="primary" data-bs-theme="dark" style={{padding:20,}}>
                <Navbar.Brand href="/">The Coaches Handbook</Navbar.Brand>
                <Navbar.Collapse className="justify-content-end">
                    <Navbar.Text>
                        <Link to={`/`}><FontAwesomeIcon icon={faHandPointLeft} />{" "}Back to Dashboard</Link>
                    </Navbar.Text>
                </Navbar.Collapse>
        </Navbar>
    )
    }

export default NavHeader;
