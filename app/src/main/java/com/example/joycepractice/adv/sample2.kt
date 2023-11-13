package com.example.joycepractice.adv

/*
1. Lambda
-람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수.
-> 정말 익명함수라는 것이 아니라 자바에서 익명함수 다룰 때 처럼 다룰 수 있어서 그렇다.
-> value처럼 ?
    1) 메소드의 파라미터로 넘겨줄 수 있다.
    2) return 값으로 사용 할 수 있다.
-람다의 기본 정의
 val lamdaName : Type = {argumentList -> codeBody}
-중괄호를 사용하면 어떤 함수를 변수안에 넣을 수 있구나! 를 깨닫는것이 중요하다.
-Type = (입력파라미터) -> (출력파라미터) : (입력파라미터는 여러 개 일수도있으니 소괄호가 필수, 출력파라미터는 소괄호 생략가능)
-왜 Type인가 했더니 1-4에 메소드의 파라미터로 넘겨주는걸 실습하는데 그때 자료형 부분에 해당 타입을 써서 그런거였음.
 */

val square : (Int) -> (Int) = {number -> number * number}
val square2 = {number : Int -> number * number}
val nameAge = {name : String, age:Int -> "my name is ${name} I'm ${age}"}

fun main(){
    println(square(2))
    println(nameAge("jsj",29))

    val a = "joyce said"
    val b = "mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    //1-2
    println(extendString("ariana",22))
    //1-3
    println(calculateGrade(97))
    //1-4
    val lambda : (Double) -> Boolean = { number ->
        number == 4.3213
    }
    println(invokeLambda(lambda))
    //람다 리터럴방식 바로 중괄호를 쓰는 방식
    println(invokeLambda { it > 3.22 }) //5.2343이 3.22보다 크니까 true, 함수의 마지막 파라미터가 람다식일 때는 저렇게 소괄호 생략하고 {} 만 써도됨.
}

/*
1-2 확장함수
이미 있는 클래스에 함수를 추가하고싶어! == 확장함수를 사용하면된다.
*/

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}
// 확장함수의 다른 형식
fun extendString(name:String, age:Int):String {
    //파라미터가 한 개일때는 it을 이용해서 적을 수 있다.
    val introduceMySelf : String.(Int) -> String = {
        "I'm ${this}(String) and ${it}(Int) years old"
    }
    return name.introduceMySelf(age) // name = this가 되고, age가 it이 된다. (파라미터가 1개 들어가면 it으로 생략이 가능)
}

/*
1-3 람다의 리턴
마지막 표현식이 리턴값을 의미한다.
*/
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

/*
1-4 람다를 표현하는 여러가지 방법
1. 메소드의 파라미터로 넘겨질 수 있다.
*/

fun invokeLambda(lambda:(Double)->Boolean ) : Boolean {
    return lambda(5.2343)
}

/*
1-5 람다 익명내부함수
조건
    -코틀린 인터페이스가 아닌 자바 인터페이스
    -그 인터페이스는 딱 하나의 메서드만 가져야한다.
*/