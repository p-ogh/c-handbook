function newMessage(topicName) {
    var ps = document.getElementsByTagName('p');
  console.log(ps)
    for (var i = 0; i < ps.length; i++) {

        if(ps[i].dataset.topicName == topicName){
              console.log(ps[i].dataset.topicName);

            ps[i].style = "background-color: red;"
        }
    }

    }


// Example case
document.body.innerHTML = `<div>
  <p data-topic-name="discussion">General discussion</p>
  <p data-topic-name="bugs">Bugs</p>
  <p data-topic-name="animals">Animals</p>
</div>`;
newMessage("discussion");
console.log(document.body.innerHTML);