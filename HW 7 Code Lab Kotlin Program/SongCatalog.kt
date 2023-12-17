class Song {
    var title: String = "" 
    var artist: String = ""
    var yearPublished: Int? = null 
    var playCount: Int = 0

    fun isPopular(): Boolean {
        return playCount >= 1000
    }

    fun songDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }   
}

fun main() {    
    val mySong = Song()
    mySong.title = "Ghar"
    mySong.artist = "Piyush Mishra"
    mySong.yearPublished = 2013
    mySong.playCount = 8325764

    mySong.songDescription()
    if(mySong.isPopular()) {
        println("Song was popular")
    }
}