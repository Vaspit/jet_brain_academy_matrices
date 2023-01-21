package processor

import processor.utils.MatrixHelper

//TODO For initial commit

fun main(args: Array<String>) {
    println("1. Add matrices")
    println("2. Multiply matrix by a constant")
    println("3. Multiply matrices")
    println("4. Transpose matrix")
    println("0. Exit")

    print("Your choice: ")
    var choice = readln()

    while(choice != "0") {
        when (choice) {
            "1" -> MatrixHelper.addMatrix()
            "2" -> MatrixHelper.multiplyByConstant()
            "3" -> MatrixHelper.multiplyMatrices()
            "4" -> {
                println("1. Main diagonal")
                println("2. Side diagonal")
                println("3. Vertical line")
                println("4. Horizontal line")

                when (readln()) {
                    "1" -> MatrixHelper.transposeByMainDiagonal()
//                    "2" -> MatrixHelper.transposeBySideDiagonal()
//                    "3" -> MatrixHelper.transposeByVerticalLine()
//                    "4" -> MatrixHelper.transposeByHorizontalLine()
                }
            }
        }

        println("1. Add matrices")
        println("2. Multiply matrix by a constant")
        println("3. Multiply matrices")
        println("4. Transpose matrix")
        println("0. Exit")

        print("Your choice: ")
        choice = readln()
    }
}