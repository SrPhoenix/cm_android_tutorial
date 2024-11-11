/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

    
 fun main() {
    val cupcake : (Int) -> String = { 
        "Have a cupcake!"
    }
	val treatFunction = trickOrTreat(false ) { "$it quarters" }
	val trickFunction = trickOrTreat(true,null)
    repeat(4) {
    	treatFunction()
    }
    trickFunction()
}
fun trickOrTreat(isTrick:Boolean, extraTreat : ((Int) -> String)?) : () -> Unit {
    if(isTrick)
    	return trick
    if (extraTreat != null)
    	println(extraTreat(5))
	return treat
}

val trick = {
    println("No treats!")
}
val treat : () -> Unit  =  {
    println("Have a treat!")
}