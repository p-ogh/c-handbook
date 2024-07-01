
import AccordionComponent from './AccordionComponent.jsx'
import AddTeamModal from './AddTeamModal.jsx'
import {useState, useEffect} from 'react';
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHouseUser } from '@fortawesome/free-solid-svg-icons'
import { faShieldHalved } from '@fortawesome/free-solid-svg-icons'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import ListGroup from 'react-bootstrap/ListGroup';



function Sidebar({data, onFormSubmit}){
//     const [teamData, setTeamData] = useState([]);
//         useEffect(() => {fetchData();
//             },[]);
//
//         const fetchData = async () => {
//             //Fetch Data from Api
//             fetch('http://localhost:8181/teams/active')
//             .then(response => response.json())
//             .then(data => setTeamData(data))
//             .catch(error => console.error('Error fetching data: ', error));
//         };
    const handleFormSubmit = (newData) =>{
//             setTeamData(teamData => [...teamData, data]);
                      onFormSubmit(newData);

        }



    return(
        <div className="app-sidebar col-md-2">

             <ListGroup as="ul" className="vertical-nav-menu" variant="flush">
                  <ListGroup.Item as="li" >
                      <Link className="app-sidebar__heading" to={`/`}><FontAwesomeIcon icon={faHouseUser} />{" "}Dashboard</Link> </ListGroup.Item>
                  <ListGroup.Item as="li" disabled><h1 className="app-sidebar__heading"><FontAwesomeIcon icon={faShieldHalved} />{" "}Teams</h1></ListGroup.Item>
                  <ListGroup.Item ><AddTeamModal name="vertical_nav" onSubmit={handleFormSubmit}/></ListGroup.Item>
                  <ListGroup.Item as="li">{data.length ===0 ? (
                      <p>Please add New team to view team details</p> ) : (
                          <div className="availableTeams">
                              {data.map( (team) =>(
                                  <AccordionComponent className="vertical_nav_accordion" key={team.id} data ={team}/>
                                    )
                                      ) }
                          </div>
                      ) }
                  </ListGroup.Item>
             </ListGroup>

        </div>
        )

    }

export default Sidebar