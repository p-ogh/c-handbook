 import playerIcon from '../assets/playerIcon.png';
 import { Routes, Route, Link } from 'react-router-dom'
 import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
 import { faCircleCheck } from '@fortawesome/free-solid-svg-icons'
 import Card from 'react-bootstrap/Card';



function Player({data, caption}) {

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