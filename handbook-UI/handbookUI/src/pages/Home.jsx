import Header from '../components/Header.jsx'
import Dashboard from '../components/Dashboard.jsx'
import Footer from '../components/Footer.jsx'
import Sidebar from '../components/Sidebar.jsx'
import {useState, useEffect} from 'react';




function Home(){

        const [teamData, setTeamData] = useState([]);
            useEffect(() => {fetchData();
                },[]);

            const fetchData = async () => {
                //Fetch Data from Api
                fetch('http://localhost:8181/teams/active')
                .then(response => response.json())
                .then(data => setTeamData(data))
                .catch(error => console.error('Error fetching data: ', error));
            };
        const handleFormSubmit = (data) =>{
                setTeamData(teamData => [...teamData, data]);
            }

    return(
        <>
            <Header/>
            <div className='app-main'>
                <Sidebar data ={teamData} onFormSubmit={handleFormSubmit}/>
                <Dashboard data ={teamData} onFormSubmit={handleFormSubmit}/>
            </div>
            <Footer/>
        </>
        )

    }

export default Home