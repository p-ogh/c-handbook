import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import Form from 'react-bootstrap/Form';


function AddTeamModal({name, onSubmit}) {
  const [show, setShow] = useState(false);
  const [teamName, setTeamName] = useState('');
  const [sport, setSport] = useState('');

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);


  const handleSubmit = (e) => {
      e.preventDefault();

      async function postData() {
          try{
              const response = await fetch('http://localhost:8181/teams/team', {
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
          setShow(false);
          setTeamName('');
          setSport('');
          onSubmit(data);

          }).catch(error => {
              console.error("Error: ", error);
              });
          }

  return (
    <>
      <Button className={name}  onClick={handleShow}>
        <FontAwesomeIcon icon={faSquarePlus}/>{" "}Add New Team
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add New Team</Modal.Title>
        </Modal.Header>
        <Modal.Body>
              <Form>
                  <Form.Group className="mb-3" controlId="formTeamName">
                    <Form.Label>Team Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Team Name"  value ={teamName} onChange={(e) => setTeamName(e.target.value)}/>
                    <Form.Text className="text-muted">
                      Team Name should be unique.
                    </Form.Text>
                  </Form.Group>

                  <Form.Group className="mb-3" controlId="formSportType">
                    <Form.Label>Sport</Form.Label>
                    <Form.Control type="text" placeholder="Sport type..."  value ={sport} onChange={(e) => setSport(e.target.value)} />
                  </Form.Group>
                </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Submit
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default AddTeamModal;