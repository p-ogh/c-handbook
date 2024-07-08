function calculateFinalSpeed(initialSpeed, inclinations) {
    let speed = initialSpeed;

//for (let i = 0; i < inclinations.length; i++) {
//use "of" to loop through objects in an array
//use "in" to loop through properties in an object
    for (let incline of inclinations) {
          speed= speed - incline;
                if(speed <= 0){
                    speed = 0;
                    break;
                }
          }

        return speed;
}

console.log(calculateFinalSpeed(60, [0, 30, 0, -45, 0]));