/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    var favoriteActor :String? = "Keanu Reeves"
    if(favoriteActor!=null){
    	println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    }else{
    	println("You didn't input a name.")
    }
    
    favoriteActor  = null
    
    if(favoriteActor!=null){
    	println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    }else{
    	println("You didn't input a name.")
    }
}