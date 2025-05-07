 import playerIcon from '../assets/playerIcon.png';
 import { Link } from 'react-router-dom'
 import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
 import { faCircleCheck } from '@fortawesome/free-solid-svg-icons'
 import { faTrashCan } from '@fortawesome/free-solid-svg-icons'
 import Button from 'react-bootstrap/Button';

 import Card from 'react-bootstrap/Card';



function Player({data, caption, onDelete}) {

    const handleDeletePlayer = (id) => {
        console.log(id);

      
        async function deleteData() {
                try{
                    const response = await fetch('http://localhost:8181/athletes/athlete/'+ id, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({
                            id: id
                            })
                    });
                    return response.json();
                }catch(error){
                    console.error('Error posting form data: ', error);
                    }
                };
                deleteData().then(resp => {
                console.log("deleteResponse: ", resp);
          
                onDelete(data);
      
                }).catch(error => {
                    console.error("Error: ", error);
                    });
                }    

    return(
        <>


        <div className="col-md-3 mb-3">

        <Card>
            {data ? (
                <>
                 <div className="card-sl">

                    <Card.Img variant="top" src={playerIcon}/>

                    <Link className="card-action" to={`/#`}><FontAwesomeIcon  className="fa-xl" icon={faCircleCheck} /></Link>

                    <Card.Body>
                        <Card.Text>{data.firstName}</Card.Text>
                        <Card.Text>{data.lastName}</Card.Text>
                        <Card.Text>{data.position}</Card.Text>
                        <Card.Text>{data.status}</Card.Text>
                    </Card.Body>
                    <Link className="card-button" to={`/team`} state={{ id: data.id }}>View Player Details</Link>
                    <Button variant="primary" type="button" onClick={()=>handleDeletePlayer(data.id)}><FontAwesomeIcon icon={faTrashCan} />{" "}Delete Player</Button>

                     </div>



                </>
                ) : (
                    <Card.Text>{caption}</Card.Text>
                    )}
        </Card>
        </div>
        </>

        );
    }

export default Player;