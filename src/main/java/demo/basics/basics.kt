package demo.basics

import com.google.common.collect.Lists
import org.funktionale.option.toOption
import org.funktionale.option.Option

//main
fun main(args: Array<String>) {
    println("Hello world!")
}
//var
public var age:Int = 0
//val
public val name:String = "Dante"
//functions
public fun sum(i:Int, j:Int):Int =  i + j

//function literals
val times: (Int, Int) -> Int = { (i:Int, j:Int) -> i*j}

fun literal(){
    val x: (Int, Int) -> Int = ::sum
}
//classes
open data class User(val name:String, val age:Int, val lastName:String)

fun multi(){
    val user = User("Dante",4,"Arias")
    val (name,age) = user

}

class Developer:User("",2)
//traits
trait WithLegs{

}
//null safety
val user:User? = null
fun nullable(){
    user!!.name
}
//smart casts
class A {fun a(){}
    fun plus(b:B):Int{
        return 0
    }

    fun invoke(f:String){

    }

    fun get(x:String){

    }

    fun set(x:String,y :Int){

    }
}
class B {fun b(){}}
class c {fun c(){}}
fun smartCasts(x:Any){
    if(user != null){
        user.age
    }
    when (x){
       is A -> x.a()
       is B -> x.b()
    }
}
//operator overloading
// :::: >>>>> 2
fun overloading(){
    val a = A()
    a("")
    a["dfdsf"]
    a["sad"] = 0
    a + B()
}
//SAM
fun sam(){
    val list = arrayListOf(1,2,3,4,5,6)
    Lists.transform(list){ i ->
        i!! + 2
    }
    list.map { i -> i + 2 }
}
//FP
fun fp(){
    val user:User? = null
    val option: Option<User> = user.toOption()
}

