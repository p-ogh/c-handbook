function ensure(value) {
//== means equal value
//=== means equal value and equal type
if(value === undefined){
throw "undefined";
}else{
return value;
}
}

try {
  console.log(ensure());
} catch(err) {
  console.log(err);
}