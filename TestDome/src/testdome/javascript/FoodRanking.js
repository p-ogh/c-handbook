function setup() {
    var buttons = document.getElementsByTagName('button');

    for (let i = 0; i < buttons.length; i++) {
        buttons[i].onclick = function(event) {
            let parentElement = this.parentElement;
            let direction = this.className;

            if (direction === "up" && parentElement.previousElementSibling) {
                parentElement.parentNode.insertBefore(parentElement, parentElement.previousElementSibling);
            } else if (direction === "down" && parentElement.nextElementSibling) {
                parentElement.parentNode.insertBefore(parentElement.nextElementSibling, parentElement);


            }
        };
    }
}

document.body.innerHTML = `<ol>
  <li><button class="up">Up!</button>Taco<button class="down">Down!</button></li>
  <li><button class="up">Up!</button>Pizza<button class="down">Down!</button></li>
  <li><button class="up">Up!</button>Eggs<button class="down">Down!</button></li>
</ol>`;

setup();
document.getElementsByTagName('button')[2].click();

console.log(document.body.innerHTML);