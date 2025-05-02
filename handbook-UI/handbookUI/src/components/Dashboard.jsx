import {useState, useEffect} from 'react';
import Team from './Team.jsx'
import Button from 'react-bootstrap/Button';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import { faTrashCan } from '@fortawesome/free-solid-svg-icons'
import Container from 'react-bootstrap/Container';
import { faShieldHalved } from '@fortawesome/free-solid-svg-icons'
import AddTeamModal from './AddTeamModal.jsx'


function Dashboard({data, onFormSubmit}) {

//     const [teamData, setTeamData] = useState([]);
//
//     useEffect(() => {fetchData();
//         },[]);
//
//     const fetchData = async () => {
//         //Fetch Data from Api
//         fetch('http://localhost:8181/teams/active')
//         .then(response => response.json())
//         .then(data => setTeamData(data))
//         .catch(error => console.error('Error fetching data: ', error));
//     };


    const handleDeleteTeam = () => {
        console.log('Delete a team');
        };
  const handleFormSubmit = (data) =>{
//             setTeamData(teamData => [...teamData, data]);
                      onFormSubmit(data);

        }

    return (
        <>
            <div className="dashContainer col-md-10 bg-body-tertiary">
                 <div className="teamListHeader">
                     <div className="teamTitle">
                         <div className="team-title-icon">
                             <FontAwesomeIcon icon={faShieldHalved} style={{color: "#74C0FC",}} />
                         </div>
                         <div className="teamDescription">
                            <h5 className="text-uppercase">Team Dashboard</h5>
                            <p>List of all teams</p>
                        </div>
                    </div>
                    <div className= "cardButtons">
                        <AddTeamModal onSubmit={handleFormSubmit}/>
                        <Button variant="primary" type="button" onClick={handleDeleteTeam}><FontAwesomeIcon icon={faTrashCan} />{" "}Delete Team</Button>
                    </div>
                </div>
                <div className="teamCards">
                    {data.length ===0 ? (
                    <Team caption='No Teams to display'/> ) : (
                        <div className="row">
                            {data.map( (team) =>(
                                <Team key={team.id} data ={team}/>
                                )
                                ) }
                        </div>
                        )
                    }
                </div>
            </div>
        </>

    )
}

export default Dashboard





