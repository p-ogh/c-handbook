function formatDate(userDate) {
  // format from M/D/YYYY to YYYYMMDD
  const d = new Date(userDate);
  //getMonth gets months as from 0-11, need tp add 1 to get actual month number
  let monthNumber = d.getMonth() + 1;
  let month = (monthNumber).toString();
  if (monthNumber < 10){
    month = "0"+ month;
  }
    let day = d.getDate().toString();
  if ( d.getDate() < 10){
    day = "0"+ d.getDate().toString();
  }
  return d.getFullYear().toString()+month+day
}

console.log(formatDate("6/1/2014"));