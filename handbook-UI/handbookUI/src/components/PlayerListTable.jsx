import {useState, useEffect} from 'react';
import Player from './Player.jsx'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPersonRunning } from '@fortawesome/free-solid-svg-icons'

import AddPlayerModal from './AddPlayerModal.jsx'


function PlayerListTable({teamId, data, onFormSubmit, onHandleDelete}) {
    const id = teamId;

   
  const handleFormSubmit = (data) =>{onFormSubmit(data)}
  const handleDelete= (data) =>{onHandleDelete(data)}


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
                        <AddPlayerModal teamId={teamId} onSubmit={handleFormSubmit}/>
                    </div>
                </div>
                <div className="playerCards">
                    {data.length ===0 ? (
                    <Player caption='No Players to display'/> ) : (
                        <div className="row">
                            {data.map( (player) =>(
                                <Player key={player.id} data ={player} onDelete={handleDelete}/>
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





