 import arsenalLogo from './assets/arsenalLogo.png';
 import TeamDashboard from "./pages/TeamDashboard.jsx";
 import Home from "./pages/Home.jsx";




function Team({data, caption}) {

    return(
        <>


        <div className="card">

        <div>
            {data ? (
                <div className="card-body">
                    <div>
                        <img className="logo" src={arsenalLogo} alt="logo" width="100" height="100"/>
                    </div>

                    <div className="details">
                        <h3 className="card-title"> {data.name}</h3>
                        <p className="card-text"> {data.sport}</p>
                        <p className="card-text"> {data.season}</p>
                        <p className="card-text"> {data.status}</p>
                    </div>
                    <Link to={`/team`}>View Team</Link>


                </div>
                ) : (
                  <p className="card-text"> {caption}</p>

                    )}
        </div>
        </div>
        </>

        );
    }

export default Team;