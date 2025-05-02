import {useState, useEffect} from 'react';
import Player from './Player.jsx'
import Button from 'react-bootstrap/Button';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import { faTrashCan } from '@fortawesome/free-solid-svg-icons'
import Container from 'react-bootstrap/Container';
//import { faShieldHalved } from '@fortawesome/free-solid-svg-icons'
import { faPersonRunning } from '@fortawesome/free-solid-svg-icons'

import AddPlayerModal from './AddPlayerModal.jsx'


function PlayerListTable({data, onFormSubmit}) {

    const handleDeletePlayer = () => {
        console.log('Delete a player');
        };
  const handleFormSubmit = (data) =>{
                      onFormSubmit(data);

        }

    return (
        <>
            <div className="tableContainer col-md-10 bg-body-tertiary">
                 <div className="playerListHeader">
                     <div className="playerList-title">
                         <div className="playerList-title-icon">
                             <FontAwesomeIcon icon={faPersonRunning} style={{color: "#74C0FC",}} />
                         </div>
                         <div className="playerListDescription">
                            <h5 className="text-uppercase">Player Dashboard</h5>
                            <p>List of all players</p>
                        </div>
                    </div>
                    <div className= "cardButtons">
                        <AddPlayerModal onSubmit={handleFormSubmit}/>
                        <Button variant="primary" type="button" onClick={handleDeletePlayer}><FontAwesomeIcon icon={faTrashCan} />{" "}Delete Player</Button>
                    </div>
                </div>
                <div className="playerCards">
                    {data.length ===0 ? (
                    <Player caption='No Players to display'/> ) : (
                        <div className="row">
                            {data.map( (player) =>(
                                <Player key={player.id} data ={player}/>
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

export default PlayerListTable





