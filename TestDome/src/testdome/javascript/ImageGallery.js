function setup() {
  // Write your code here.
      var buttons = document.getElementsByTagName('button');

  for (let i = 0; i < buttons.length; i++) {
       buttons[i].onclick = function(event) {
         this.parentElement.remove();
       };
  }
}

// Example case.
document.body.innerHTML = `
<div class="image">
  <img src="https://bit.ly/3lmYVna" alt="First">
  <button class="remove">X</button>
</div>
<div class="image">
  <img src="https://bit.ly/3flyaMj" alt="Second">
  <button class="remove">X</button>
</div>`;

setup();

document.getElementsByClassName("remove")[0].click();
console.log(document.body.innerHTML);