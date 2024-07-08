function removeProperty(obj, prop) {

let hasProp = false
 if(prop in obj){
   hasProp = true;
  delete obj[prop];
 }
  return hasProp;
}