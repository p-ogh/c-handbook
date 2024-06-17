import {Accordion} from 'react-bootstrap';
import { Routes, Route, Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faShieldHalved } from '@fortawesome/free-solid-svg-icons'


function AccordionComponent({data}) {

        const accStyle = {
                 padding: 0,
                 border:0,
        }
    const teamId = data.id;

  return (
    <Accordion  id="bootstrap-overrides" style={accStyle} flush>
      <Accordion.Item eventKey="0">
        <Accordion.Header><FontAwesomeIcon icon={faShieldHalved} />{" "}{data.name}</Accordion.Header>
        <Accordion.Body>
            <div className="accordion_list">
                <ul className="list">
                     <li>
                         <Link to={'/team'} state={{ id: teamId }}>Dashboard</Link>

                     </li>
                    <li>
                        <a href="#">Schedule</a>
                    </li>
                    <li>
                        <a href="#">Roster</a>
                    </li>
                    <li>
                        <a href="#">Coaches</a>
                    </li>
                    <li>
                        <a href="#">Stats</a>
                    </li>
                </ul>
            </div>
        </Accordion.Body>
      </Accordion.Item>
    </Accordion>
  )
}

export default AccordionComponent