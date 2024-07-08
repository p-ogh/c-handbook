class Song {
  name;
  nextSong;

  constructor(name) {
    this.name = name;
  }

  /**
   * @return {boolean} true if the playlist is repeating, false if not.
   */
  isInRepeatingPlaylist() {
    // Your code goes here
    let isRepeat = false;
    const playlist = new Set();

    let song = this.nextSong;


        while(song !=null){
            if(playlist.has(song)){
                return true;
            }
            playlist.add(song);
            song = song.nextSong;
        }


        return isRepeat;


  }
}

let first = new Song("Hello");
let second = new Song("Eye of the tiger");

first.nextSong = second;
second.nextSong = first;

console.log(first.isInRepeatingPlaylist());