import Header from '../components/Header.jsx'
import PlayerListTable from '../components/PlayerListTable.jsx'
import Footer from '../components/Footer.jsx'
import Sidebar from '../components/Sidebar.jsx'
import {useState, useEffect} from 'react';
import { useLocation } from 'react-router-dom';





function PlayerList(){
     const location = useLocation();
        const { id } = location.state;

        const [playersData, setPlayersData] = useState([]);
        useEffect(() => {fetchPlayerData();
                },[]);

        const fetchPlayerData = async () => {
                //Fetch Data from Api
                fetch('http://localhost:8181/athletes/team/'+ id)
                .then(response => response.json())
                .then(data => setPlayersData(data))
                .catch(error => console.error('Error fetching data: ', error));
            };
        const handleFormSubmit = (data) =>{
            setPlayersData(playersData => [...playersData, data]);
            }
            const handleDelete = (data) =>{console.log("player was deleted")   }


                    const [teamsData, setTeamsData] = useState([]);
                    useEffect(() => {fetchData();
                        },[]);
                
                    const fetchData = async () => {
                                //Fetch Data from Api
                        fetch('http://localhost:8181/teams/active')
                        .then(response => response.json())
                        .then(data => setTeamsData(data))
                        .catch(error => console.error('Error fetching data: ', error));
                            };

    return(
        <>
            <Header/>
            <div className='app-main'>
                <Sidebar data ={teamsData} onFormSubmit={handleFormSubmit}/>
                <PlayerListTable teamId ={id} data ={playersData} onFormSubmit={handleFormSubmit} onHandleDelete={handleDelete}/>
            </div>
            <Footer/>
        </>
        )

    }

export default PlayerList