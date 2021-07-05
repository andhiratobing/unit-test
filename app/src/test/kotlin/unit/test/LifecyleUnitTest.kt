package unit.test

import org.junit.jupiter.api.*

/*Mengurutkan running test*/
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)

//@TestInstance(value = TestInstance.Lifecycle.PER_CLASS) /*Lifecyle 1*/
@TestInstance(value = TestInstance.Lifecycle.PER_METHOD) /*Lifecyle 2*/
class LifecyleUnitTest {
    /**
     * Jika Lifecycle.PER_CLASS maka instance akan sama
     * Jika Lifecycle.PER_METHOD maka instance akan berbeda
     * Secara default Lifecycle Unit Test menggunakan Lifecycle.PER_METHOD
     * Penggunaan Lifecycle.PER_CLASS digunakan secara bijak, karena jika tidak bijak dapat merusak function lain
     *
     * Keuntungan menggunakan Lifecycle.PER_CLASS dapat menggunakan anotasi
     * @BeforeAll dan @AfterAll pada function biasa tanpa hsrus menggunakan function object/static
     */


    var count = 0

    @Test
    @Order(2)
    fun sampleSecond(){
        //check instance number
        count++
        println(count)
        println(this.hashCode())
    }

    @Test
    @Order(3)
    fun sampleThird(){
        //check instance number
        count++
        println(count)
        println(this.hashCode())
    }

    @Test
    @Order(1)
    fun sampleFirst(){
        //check instance number
        count++
        println(count)
        println(this.hashCode())
    }


//    @Test
//    @BeforeAll
//    fun beforeAll(){
//        //Code
//    }
//
//    @Test
//    @AfterAll
//    fun AfterAll(){
//        //Code
//    }

}