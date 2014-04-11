package demo.delegates


import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

fun main(args: Array<String>) {
    val user = User()
    user.age = 33
    user.lastName = "Arias"
    user.firstName = "Mario"
    println("user.role = ${user.role}")
    println("user.age = ${user.age}")
    println("user.lastName = ${user.lastName}")
    println("user.firstName = ${user.firstName}")
}

class User {
    val role: String by Delegates.lazy {
        println("computed")
        "User"
    }

    var lastName:String by Delegates.observable(""){ desc, old, new ->
        println("I like your new lastName")
    }
    var firstName:String by Delegates.vetoable(""){ desc, old, new ->
        !new.startsWith("Mario")
    }
    var age: Int by Counter(0)
}

class Counter<R, T>(var initialValue: T) : ReadWriteProperty<R, T> {

    var getCounter = 0
    var setCounter = 0

    override fun get(thisRef: R, desc: PropertyMetadata): T {
        getCounter++
        println("property ${desc.name} readed $getCounter times")
        return initialValue
    }
    override fun set(thisRef: R, desc: PropertyMetadata, value: T) {
        setCounter++
        println("property ${desc.name} writed $setCounter times")
        initialValue = value
    }
}

trait UserReadOperation {
    fun findAll(): List<User>
}

class UserDao : UserReadOperation {
    override fun findAll(): List<User> {
        return listOf(User(), User())
    }

}

class UserService(userDao: UserDao) : UserReadOperation by userDao {

}
