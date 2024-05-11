import {useState} from 'react';

function Navbar(){
                const [isOpen, setIsOpen] = useState(false);

    return(
        <nav className="navbar navbar-expand-lg navbar-dark bg-transparent">
                          <div className="container">
                            <a className="navbar-brand" href="#">The Coaches Handbook</a>
                            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
                              <span className="navbar-toggler-icon"></span>
                            </button>

                            <div className="collapse navbar-collapse" id="navbarsExample07">
                              <ul className="navbar-nav mr-auto">
                                <li className="nav-item active">
                                  <a className="nav-link" href="#">Dashboard <span className="sr-only">(current)</span></a>
                                </li>
                                <li className="nav-item">
                                  <a className="nav-link" href="#">Schedule</a>
                                </li>
                                <li className="nav-item">
                                  <a className="nav-link" href="#">Stats</a>
                                </li>

                              </ul>
                                <div className="nav-item dropdown">
                                   <a className="dropdown-toggle"  onClick={() => setIsOpen(!isOpen)}>Menu</a>

                                   <ul className={isOpen ? "dropdown-menu active" : "dropdown-menu"}>
                                       <li><a className="dropdown-item" href="#">Dashboard</a></li>
                                       <li><a className="dropdown-item" href="#">Coaches</a></li>
                                       <li><a className="dropdown-item" href="#">Athletes</a></li>
                                       <li><a className="dropdown-item" href="#">Teams</a></li>
                                       <li><hr className="dropdown-divider"/></li>
                                       <li><a className="dropdown-item" href="#">Schedule</a></li>
                                       <li><a className="dropdown-item" href="#">Practices</a></li>
                                        <li><a className="dropdown-item" href="#">Games</a></li>
                                   </ul>
                                    </div>

                              <form className="form-inline my-2 my-md-0">
                                <input className="form-control" type="text" placeholder="Search" aria-label="Search"/>
                              </form>
                            </div>
                          </div>
                        </nav>
           );
    }

export default Navbar;
