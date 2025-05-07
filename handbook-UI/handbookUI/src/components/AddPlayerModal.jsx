import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSquarePlus } from '@fortawesome/free-solid-svg-icons'
import Form from 'react-bootstrap/Form';


function AddPlayerModal({teamId, name, onSubmit}) {
  const id = teamId;

  const [show, setShow] = useState(false);
  const [lastName, setLastName] = useState('');
  const [firstName, setFirstName] = useState('');
  const [gender, setGender] = useState('');


  const [position, setPosition] = useState('');

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);


  const handleSubmit = (e) => {
      e.preventDefault();

      async function postData() {
          try{
              const response = await fetch('http://localhost:8181/athletes/team/'+ id, {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json',
                  },
              body: JSON.stringify({
                  firstName: firstName,
                  lastName: lastName,
                  gender: gender,
                  role: position
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
          setFirstName('');
          setLastName('');
          setGender('');
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
                  <Form.Group className="mb-3" controlId="formFirstName">
                    <Form.Label>First Name</Form.Label>
                    <Form.Control type="text" placeholder="First Name"  value ={firstName} onChange={(e) => setFirstName(e.target.value)}/>
                    <Form.Text className="text-muted">Please enter Alpanumeric values.</Form.Text>

                  </Form.Group>
                  <Form.Group className="mb-3" controlId="formLastName">
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control type="text" placeholder="Last Name"  value ={lastName} onChange={(e) => setLastName(e.target.value)}/>
                    <Form.Text className="text-muted">Please enter Alpanumeric values.</Form.Text>
                  </Form.Group>

                  <Form.Group className="mb-3" controlId="formGenderSelect">
                  <Form.Label>Gender</Form.Label>
                    <Form.Select aria-label="Default select example">
                      <option>Select an option</option>
                      <option value="M">Male</option>
                      <option value="F">Female</option>
                    </Form.Select>
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