import {useState, useEffect} from 'react';
import Team from './Team.jsx'



function Dashboard() {
    const showStyle = {
        display: 'block',
        paddingRight: 15,
    }

    const noneStyle = {
        display: 'none',
    }
    const [teamData, setTeamData] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [style, setStyle] = useState(noneStyle);
    const [teamName, setTeamName] = useState('');
    const [sport, setSport] = useState('');



    useEffect(() => {fetchData();
        },[]);

    const fetchData = async () => {
        //Fetch Data from Api
        fetch('http://localhost:8181/teams/active')
        .then(response => response.json())
        .then(data => setTeamData(data))
        .catch(error => console.error('Error fetching data: ', error));
    };

    const handleAddTeam = () => {
        setShowForm(true);
        setStyle(showStyle);

    };
    const handleDeleteTeam = () => {
        console.log('Delete a team');
        };
   const handleClose = () => {
        setShowForm(false);
        setStyle(noneStyle);
    };

   const handleSubmit = (e) => {
       e.preventDefault();

       async function postData() {
        try{
            const response = await fetch('http://localhost:8181/teams/new', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                },
            body: JSON.stringify({
                name: teamName,
                sport: sport
                })

            });
            return response.json();
        }catch(error){
            console.error('Error posting form data: ', error);
            }
        };
        postData().then(data => {
            console.log("postResponse: ", data);
            setShowForm(false);
            setStyle(noneStyle);
            setTeamName('');
            setSport('');
            setTeamData(teamData => [...teamData, data]);

        }).catch(error => {
            console.error("Error: ", error);
            });
        }



    return (
        <div>

            <div className= "cardButtons">
                <button  type="button" className="btn btn-light" onClick={handleAddTeam}>Add New Team</button>
                <button type="button" className="btn btn-light" onClick={handleDeleteTeam}>Delete Team</button>
            </div>

                <div className={showForm ? "modal fade show" : "modal fade"} tabIndex="-1" role="dialog" style={style}>
                  <div className="modal-dialog" role="document">
                    <div className="modal-content">

                      <div className="modal-header">
                        <h5 className="modal-title" id="modalTitle">Add New Team</h5>
                        <button type="button" className="btn" onClick={handleClose} aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div className="modal-body">
                          <form>
                              <div className="form-group">
                                  <label htmlFor="teamName">Team Name</label>
                                  <input type="text" className="form-control" id="teamName" aria-describedby="teamNameHelp"  value ={teamName} onChange={(e) => setTeamName(e.target.value)}  placeholder="Enter team name"/>
                                  <small id="teamNameHelp" className="form-text text-muted">Use a unique name.</small>
                              </div>
                              <div className="form-group">
                                  <label htmlFor="sportType">Sport</label>
                                  <input type="text" className="form-control" id="sportType" value ={sport} onChange={(e) => setSport(e.target.value)} placeholder="Sport type..."/>
                              </div>
                              <div className="form-check">
                                  <input type="checkbox" className="form-check-input" id="activeTeam"/>
                                  <label className="form-check-label" htmlFor="activeTeam">Active</label>
                              </div>
                          </form>
                      </div>
                      <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" onClick={handleClose} >Close</button>
                        <button type="submit" onClick={handleSubmit} className="btn btn-primary">Submit</button>
                      </div>

                    </div>
                  </div>
                </div>




            <div className="card-list">
                {teamData.length ===0 ? (
                <Team caption ='No Teams to display'/> ) : (
                <div>
                    {teamData.map((team) =>(<Team key={team.id} data ={team}/>))}
                </div>
                )
                }
            </div>
        </div>

    )
}

export default Dashboard





