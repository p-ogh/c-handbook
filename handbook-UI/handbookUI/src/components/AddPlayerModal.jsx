import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import Form from 'react-bootstrap/Form';


function AddPlayerModal({name, onSubmit}) {
  const [show, setShow] = useState(false);
  const [playerName, setPlayerName] = useState('');
  const [position, setPosition] = useState('');

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);


  const handleSubmit = (e) => {
      e.preventDefault();

      async function postData() {
          try{
              const response = await fetch('http://localhost:8181/players/player', {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json',
                  },
              body: JSON.stringify({
                  name: playerName,
                  position: position
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
          setPlayerName('');
          setPosition('');
          onSubmit(data);

          }).catch(error => {
              console.error("Error: ", error);
              });
          }

  return (
    <>
      <Button className={name}  onClick={handleShow}>
        <FontAwesomeIcon icon={faSquarePlus}/>{" "}Add New Player
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add New Player</Modal.Title>
        </Modal.Header>
        <Modal.Body>
              <Form>
                  <Form.Group className="mb-3" controlId="formPlayerName">
                    <Form.Label>Player Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Players Name"  value ={playerName} onChange={(e) => setPlayerName(e.target.value)}/>
                    <Form.Text className="text-muted">
                      Player Name should be unique.
                    </Form.Text>
                  </Form.Group>

                  <Form.Group className="mb-3" controlId="formPosition">
                    <Form.Label>Position</Form.Label>
                    <Form.Control type="text" placeholder="Position..."  value ={position} onChange={(e) => setPosition(e.target.value)} />
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

export default AddPlayerModal;