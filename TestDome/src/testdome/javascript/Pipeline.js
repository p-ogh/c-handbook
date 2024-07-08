function pipeline(...funcs) {
  return (arg) => {
for (let func of funcs){
 arg = func(arg);
}
    return arg;
  }
}

let fun = pipeline(x => x * 3, x => x + 1, x => x / 2);
console.log(fun(3));