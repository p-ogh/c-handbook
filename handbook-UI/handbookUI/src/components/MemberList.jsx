import {useState, useEffect} from 'react';


function List() {
    const [userData, setUserData] = useState([]);
    useEffect(() => {
        //Fetch Data from Api
        fetch('http://localhost:8181/coaches/all')
        .then(response => response.json())
        .then(data => setUserData(data))
        .catch(error => console.error('Error fetching data: ', error));
        },[]);

    return(
        <div className="card-list">
            {userData.map((user) =>(
                   <div className="card" key={user.id}>
                                <h3> {user.firstName} {user.lastName}</h3>
                                <p> {user.role}</p>
                   </div>
                ))}


        </div>

        );
    }

export default List;