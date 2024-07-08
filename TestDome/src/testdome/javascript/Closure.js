function registerHandlers() {
  var as = document.getElementsByTagName('a');
  for (var i = 0; i < as.length; i++) {
  (function(index){
   as[index].onclick = function(event) {
        alert(index);
        event.preventDefault();
      };
  })(i);

  }
}

/* HTML code for testing purposes (do not submit uncommented):
<body>
  In my life, I used the following web search engines:<br/>
  <a href="//www.yahoo.com">Yahoo!</a><br/>
  <a href="//www.altavista.com">AltaVista</a><br/>
  <a href="//www.google.com">Google</a><br/>
</body>
*/