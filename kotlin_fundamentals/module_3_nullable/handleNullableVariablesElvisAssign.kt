/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    var favoriteActor :String? = "Keanu Reeves"
    
    var numOfchars : Int = favoriteActor?.length ?: 0
    
    println("The number of characters in your favorite actor's name is ${numOfchars}.")
    
    favoriteActor  = null
    
    numOfchars = favoriteActor?.length ?: 0
 
    println("The number of characters in your favorite actor's name is ${numOfchars}.")
}