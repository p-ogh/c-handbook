 import arsenalLogo from '../assets/arsenalLogo.png';
 import { Routes, Route, Link } from 'react-router-dom'
 import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
 import { faCircleCheck } from '@fortawesome/free-solid-svg-icons'





function Team({data, caption}) {

    return(
        <>


        <div className="col-md-3 mb-3">

        <div>
            {data ? (
                <div className="card-sl">
                    <div className="card-image">
                        <img className="logo" src={arsenalLogo} alt="logo" width="100" height="100"/>
                    </div>

                    <a className="card-action" href="#"><FontAwesomeIcon icon={faCircleCheck} /></a>

                        <div className="card-heading">{data.name}</div>
                        <div className="card-text">{data.sport}</div>
                        <div className="card-text"> {data.status}</div>
                    <Link className="card-button" to={`/team`}>View Team</Link>


                </div>
                ) : (
                  <div className="card-text">{caption}</div>


                    )}
        </div>
        </div>
        </>

        );
    }

export default Team;