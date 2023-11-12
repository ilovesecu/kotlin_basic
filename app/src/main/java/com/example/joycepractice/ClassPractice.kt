package com.example.joycepractice

//굳이 파일명이랑 Class랑 같지 않아도 된다.
open class Human constructor(val age:Int = 10){ //val age도 멤버변수임.
    val name = "joyce"; //멤버변수
    val address = "damyang";
    init{
        //생성자의 역할이 변수를 초기화하는 것 뿐만아니라 객체 생성시 코드 블록을 실행하는 것도 있으므로 init 이라는 키워드를 사용하면
        //객체 생성 시 코드블록을 실행할 수 있다.
        println("New human has been born!!")
    }

    //생성자 오버로딩은 어떻게 구현하느냐? 부생성자를 통해서 구현하면된다. (constructor 키워드 사용)
    constructor(name: String, age:Int, address:String):this(age){
        // :this(age)는 부생성자는 무조건 주생성자의 위임을 받아야해서 age를 주생성자로부터 받아오는것.
        println("My name is ${name}, ${age}, ${address}");
    }

    fun eatingCake(){
        println("This is so YUMMMMYY~~~");
    }

    open fun singASong(){
        println("lalalalal!");
    }
}

//상속!
class Korean : Human(){ // class 클래스명:상속받을 클래스명   ==> 상속받을 클래스는 앞에 open이 붙어 있어야함!

    //메서드 오버라이딩을 하고싶다면?
    override fun singASong(){ // override를 받고싶다면 상위 클래스의 메서드는 open 키워드가 있어야함!
        super.singASong(); //상위 클래스의 메서드도 호출
        println("라라라라라");
        println("Korean name:${name}"); //상속을 했기 때문에 상위 클래스의 멤버 사용가능.
    }
}

fun main(){
    val human = Human(); //JAVA에서는 객체를 생성할 때 new를 사용했지만 코틀린은 그냥 "클래스()" 해주면된다.
    human.eatingCake();
    println("this human's name is ${human.name} age:${human.age}");

    // --> 생성자를 이용해서 필드를 초기화하고싶다면?
    //자바와 다른 문법을 사용한다. 기본생성자는 class 클래스명 constructor(){} 이렇게 정의된다. -> constructor 키워드 생략가능
    //멤버선언과 동시에 하려면 class 클래스명 (val age:Int){} 이렇게 하면된다.
    val human2 = Human(120); //생성자 사용
    val human3 = Human("sj",130,"gwangju"); //부 생성자를 사용하기 때문에 init구문 다음에 실행이 되는것을 생각하고 있어야함.
    println("this human's name is ${human2.name} age:${human2.age}");

    val korean = Korean();
    korean.singASong(); //메서드 오버라이딩
}