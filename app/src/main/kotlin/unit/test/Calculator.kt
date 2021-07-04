package unit.test

class Calculator {

    /*Penjumlahan*/
    fun sum(first: Int, second: Int): Int {
        return first + second
    }

    /*Pembagian dengan nilai 0 tidak boleh (IllegalArgumentException)*/
    fun divide(first: Int, second: Int): Int {
        if (second == 0){
            throw IllegalArgumentException("Can't divide by zero")
        }else{
            return first/second
        }
    }

}