package demo.extensions

fun Int.println(s:String){
   println("$this + $s")
}

fun extensions(){
    3.println("")
}
