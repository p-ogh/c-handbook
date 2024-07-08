function appendChildren(decorateDiv) {
  var allDivs = document.getElementsByTagName("div");
  var divsArray = Array.from(allDivs); //create a static copy of the collection, if you use
  //the allDivs HTML collection it will alter the current dom, thus increasing its length each time a new div is added.

  for (let i = 0; i < divsArray.length; i++) {
    var newDiv = document.createElement("div");
    decorateDiv(newDiv);
    divsArray[i].appendChild(newDiv);
  }
}

// Example case.
document.body.innerHTML = `
<div id="a">
  <div id="b">
  </div>
</div>`;

//appendChildren(function(div) {});
console.log(document.body.innerHTML);