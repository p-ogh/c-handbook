import {useState} from 'react';

function Header(){
            const [isOpen, setIsOpen] = useState(false);


    return(
        <>
        <header className="mb-3 header">

                <nav className="navbar navbar-expand-lg navbar-dark bg-transparent">
                  <div className="container">
                    <a className="navbar-brand" href="#">The Coaches Handbook</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
                      <span className="navbar-toggler-icon"></span>
                    </button>

                     <h5>Dashboard</h5>
                  </div>
                </nav>

        </header>

        </>

    )
}

export default Header