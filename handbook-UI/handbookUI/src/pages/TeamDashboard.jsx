import NavHeader from '../components/NavHeader.jsx'
import Footer from '../components/Footer.jsx'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPersonRunning } from '@fortawesome/free-solid-svg-icons'
import { faCalendarDays } from '@fortawesome/free-solid-svg-icons'
import { faFutbol } from '@fortawesome/free-solid-svg-icons'
import { faClipboard } from '@fortawesome/free-solid-svg-icons'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import Form from 'react-bootstrap/Form';
import { useLocation } from 'react-router-dom'



function TeamDashboard(){
const location = useLocation();
const { id } = location.state;
console.log(id);

    return(
            <>
                <NavHeader/>
                <div className="teamDashboard container-fluid">
                  <section>
                    <div className="row">
                      <div className="col-12 mt-3 mb-1">
                          <div className="dashHeader">
                        <h5 className="text-uppercase">Team Dashboard</h5>
                        <Form.Select className="mb-4">
                            <option>Season 2023/2024 (Current)</option>
                            <option value="1">Add New Season</option>
                            <option value="1">2022/2023</option>
                            <option value="2">2021/2022</option>
                            <option value="3">2020/2021</option>
                        </Form.Select>
                        </div>
                      </div>
                    </div>
                    <div className="row">
                      <div className="col-xl-6 col-md-12 mb-4">
                        <div className="card">
                          <div className="card-body">
                            <div className="d-flex justify-content-between p-md-1">
                              <div className="d-flex flex-row">
                                <div className="align-self-center">
                                  <FontAwesomeIcon className="text-info fa-3x me-4" icon={faPersonRunning} />
                                </div>
                                <div>
                                  <h4>Active Players</h4>
                                  <p className="mb-0">Player Profiles</p>
                                </div>
                              </div>
                              <div className="align-self-center">
                                <h2 className="h1 mb-0">12</h2>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div className="col-xl-6 col-md-12 mb-4">
                        <div className="card">
                          <div className="card-body">
                            <div className="d-flex justify-content-between p-md-1">
                              <div className="d-flex flex-row">
                                <div className="align-self-center">
                                  <FontAwesomeIcon className="text-warning fa-3x me-4" icon={faCalendarDays} />
                                </div>
                                <div>
                                  <h4>Upcoming Events</h4>
                                  <p className="mb-0">Schedule</p>
                                </div>
                              </div>
                              <div className="align-self-center">
                                <h2 className="h1 mb-0">55</h2>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div className="row">
                      <div className="col-xl-6 col-md-12 mb-4">
                        <div className="card">
                          <div className="card-body">
                            <div className="d-flex justify-content-between p-md-1">
                              <div className="d-flex flex-row">
                                <div className="align-self-center">
                                  <h2 className="h1 mb-0 me-4">3</h2>
                                </div>
                                <div>
                                  <h4>Past Seasons</h4>
                                  <p className="mb-0">History</p>
                                </div>
                              </div>
                              <div className="align-self-center">
                                <FontAwesomeIcon  className="text-danger fa-3x" icon={faClipboard} />
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div className="col-xl-6 col-md-12 mb-4">
                        <div className="card">
                          <div className="card-body">
                            <div className="d-flex justify-content-between p-md-1">
                              <div className="d-flex flex-row">
                                <div className="align-self-center">
                                  <h2 className="h1 mb-0 me-4">38</h2>
                                </div>
                                <div>
                                  <h4>Games Played</h4>
                                  <p className="mb-0">Games</p>
                                </div>
                              </div>
                              <div className="align-self-center">
                                <FontAwesomeIcon className="text-success fa-3x" icon={faFutbol} />
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </section>
                </div>

                <Footer/>
            </>
            )

    }

export default TeamDashboard