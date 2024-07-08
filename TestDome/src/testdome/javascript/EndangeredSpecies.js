function endangeredSpecies(continent) {
    var ps = document.getElementsByTagName('li');
        for (var i = 0; i < ps.length; i++) {
            if(ps[i].dataset.continent == continent){
              return ps[i].innerHTML;
            }
        }
}

// Example case
document.body.innerHTML =
`<div>
    <ul>
        <li data-continent="North America">California condor</li>
        <li data-continent="Europe">Cave bear</li>
    </ul>
</div>`;

console.log(endangeredSpecies("North America")); // should print 'California condor'