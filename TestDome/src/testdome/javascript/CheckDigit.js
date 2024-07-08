function createCheckDigit(membershipId) {
  let sum = sumDigit(membershipId);


  while(sum >= 10){
    sum = sumDigit(sum.toString())

  }

  return sum;
}

function sumDigit(id){

    let sum = 0;
    for(let i = 0; i< id.length; i++){
        sum += Number(id.charAt(i))
    }

  return sum;

}
console.log(createCheckDigit("55555"));