package com.example.joycepractice

//처음 시작하는 포인트 = main
fun main(){
    hello();
    var a:Int = add(1,2);
    println(a);
    templateString();

    checkNum(10)
    forAndWhile()
    nullcheck();
}

//1. 함수

/*
    fun [함수명](파라미터): return 자료형 => return 없다면 생략 가능.
 */
fun hello(): Unit{ //Unit은 void와 같음.
    println("Hello World");
}

fun add(a: Int, b:Int):Int {
    return a + b;
}

/*
 2. val vs var
 val => value => 변하지 않는 값(상수)
*/
fun valvar(){
    val a : Int = 10;
    var b : Int = 9;
    //a = 100; //Error (final int 같은 느낌)
    b = 90; //변수니까 재정의 가능!
    println(b);
}

/*
 3. 코틀린은 타입 추론 기능이 있기 때문에 굳이 타입을 안써도 된다.
 하지만 선언 후 대입을 바로 해주지 않을 때는 타입을 정의해줘야한다.
*/
fun type(){
    val a = 10;
    var b = 20; //굳이 Int를 안써도 된다.
    var str = "ilovepc"; //굳이 String을 안써도 된다.

    // var e; //이렇게 하려면 타입을 알려줘야함.
    var e : String;
}

/*
   4. String template 이란것이 있다.
   js의 리터럴 템플릿과 굉장히 유사하다. ${변수명}
*/
fun templateString(){
    val name = "Joyce";
    val last = "Jeong";
    println("my name is ${name}");
    println("my name is ${name+" "+last}");
    // $표시를 출력하고 싶을 때
    println("4딸라! \$4");
}

/*
    5. 조건식
*/
fun maxBy(a:Int, b:Int):Int{
    //해당 부분은 다른 언어와 동일!
    if(a > b){
        return a;
    }else{
        return b;
    }
}
//뭔가 {} 를 빠트리면 return문을 생략가능 하다는 점이 js 화살표 함수와 비슷하다.
fun maxBy2(a:Int, b:Int) = if(a>b) a else b

//when == switch
fun checkNum(score:Int){
    // when == switch 문과 비슷
    when(score){
        0 -> println("this is zero")
        1 -> println("this is one")
        2,3 -> println("this is two or three")
        else -> println("i don't know")
    }
    //when은 반환되는 값을 바로 변수에 담을수도 있다.
    var b = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b: ${b}");

    var str = when(score){
        in 90..100 -> "You are genius"
        in 10..80 -> "not bad"
        else -> "okky"
    }
    println("str: ${str}");
}

/*
 Expression vs Statement
 Expression : 뽀짝뽀짝 해서 값을 만들면 Expression
    -모든 함수 (리턴이 없어도 Unit을 만들기도 하니까)
 Statement : 이거이거 해 명령을 지시함.
*/

/*
 6. Array vs List
 - Array : 정적 메모리 할당 (이미 배열의 크기가 정해져있음.)
 - List
    1. List (수정 불가능 리스트) [읽기 전용]
    2. Mutable List (수정 가능 리스트) [읽기, 쓰기 가능]
*/
fun array(){
    val array = arrayOf(1,2,3);
    val list = listOf(1,2,3);

    val array2 = arrayOf(1,"d",4.5f);
    val list2 = listOf(1,2,"dfadsf",'c',123L);

    //배열은 기본적으로 수정이 됨. (크기 빼고)
    array[1] = 4;
    //List는 읽기 전용임. (Interface 이며, get만 구현)
    val result = list.get(0);
    //ArrayList는 수정 가능 리스트임.
    val arrayList = arrayListOf<Int>(1,2);
    arrayList.add(10);
    arrayList.add(20);
}

/*
7. 반복문
for, while
*/
fun forAndWhile(){
    val students = arrayListOf<String>("joyce", "james", "jenny","sj")
    for(name in students){
        //js와 비슷하게 in이라는 키워드로 for반복문 사용
        println("${name}")
    }
    //1 ~ 10 (포함)
    var sum = 0;
    for(i in 1..10){
        sum += i;
    }

    // 2씩 증가
    var odd = 0;
    for(i in 1..10 step 2){
        //1 3 5 7 9
        odd += i;
    }
    println("sum:${sum}, odd:${odd }");

    // 1씩 감소
    for(i in 10 downTo 1){
        //10 9 8 7 6 5 .. 1
        print("${i} ")
    }

    // 100을 포함하지 않는다.
    for(i in 1 until 100){
        print("${i} ")
    }
    println("")

    //for문 index와 함께 사용
    for((index, name) in students.withIndex() ){
        //index와 name을 함께 사용가능
        println("${index+1}번째 학생 이름:${name}")
    }

    //while문
    var index = 0;
    while(index < 10){
        //println("current Index : ${index}");
        index++;
    }
}

/*
JAVA와 가장 큰 차이점
Nullable / NonNull
*/
fun nullcheck(){
    //NPE : Null Pointer Exception - Runtime Error
    //? 연산자 컴파일 시점에 NPE를 잡아줄게!
    var name : String = "joyce";
    //var nullName : String = null; // NonNull Type
    var nullableName : String? = null; //Nullable Type ?키워드
    var nameInUpperCase : String = name.uppercase();
    var nullNameInUpperCase : String? = nullableName?.uppercase(); // JS의 ?.와 비슷하다. nullableName이 null인지 판별해서 null이 아니라면 uppercase()를하고, 아니면 null을 반환한다.
    
    // ?: 엘리스뭐시기 연산자 --> 해당 값이 null이면? ~~ 해라 를 지정할 수 있다. [기본값 지정]
    val lastName : String? = null;
    val fullName = name + (lastName?:"No LastName")
    println(fullName)

    // !! 컴파일러한테 이거 null아니야! 라고 내가 보증해줄게 라고 말해주는것
    fun ignoreNulls(str:String?){
        //val mNotNull : String = str; // null이 올 수 있어서 String type 선언 불가능
        val mNotNull : String = str!!; // 하지만 !! 연산자를 사용하면 이거 내가 보증하는데 null 아니야! (사용은 좀 지양해야함. NPE 나올수도있음)
    }

    // let 함수 -> 자신의 리시버 객체를 람다식 내부로 옮겨서 실행하는 구문
    val email : String? = "ilovepc@naver.com"
    email.let {
        //email이 null이 아니면 해당 람다식 내부로 email을 옮겨준다.
        println("my email is ${it} ${email}")
    }
}
