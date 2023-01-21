package processor.utils

typealias Matrix = ArrayList<ArrayList<Double>>

object MatrixHelper {

    private fun setMatrixDimension(): ArrayList<Int> {
        val dimensionString = readln()
        return dimensionString.convertToDigitArray()
    }

    private fun createMatrix(matrixName: String): Matrix {
        print("Enter size of $matrixName matrix: ")
        val matrixDimension = setMatrixDimension()

        println("Enter $matrixName matrix:")
        val matrixRowsNumber = matrixDimension[0]
        val matrix: Matrix = arrayListOf()

        for (i in 0 until matrixRowsNumber) { matrix.add(getRow()) }

        return matrix
    }

    private fun createZeroMatrix(rowsNumber: Int, columnsNumber: Int): Matrix {
        val result = Matrix()

        for (row in 0 until rowsNumber) {
            result.add(arrayListOf())
            for (item in 0 until columnsNumber) {
                result[row].add(0.0)
            }
        }

        return result
    }

    fun addMatrix() {
        val firstMatrix = createMatrix("first")
        val secondMatrix = createMatrix("second")
        val result = createZeroMatrix(rowsNumber = firstMatrix.size, columnsNumber = firstMatrix[0].size)

        if (isMatrixAddable(firstMatrix, secondMatrix)) {
            for (row in 0 until firstMatrix.size) {
                for (item in 0 until firstMatrix[0].size) {
                    result[row][item] = firstMatrix[row][item] + secondMatrix[row][item]
                }
            }

            println("The result is:")
            printMatrix(result)
            println()
        } else {
            print("ERROR")
        }
    }

    fun multiplyMatrices() {
        val firstMatrix = createMatrix("first")
        val secondMatrix = createMatrix("second")

        if (isMatrixMultipliable(firstMatrix, secondMatrix)) {
            val result = createZeroMatrix(firstMatrix.size, secondMatrix[0].size)

            for (i in 0 until firstMatrix.size) {
                for (k in 0 until secondMatrix[0].size) {
                    for (j in 0 until firstMatrix[0].size) {
                        result[i][k] += firstMatrix[i][j] * secondMatrix[j][k]
                    }
                }
            }

            println("The result is:")
            printMatrix(result)
            println()
        } else {
            println("The operation cannot be performed.")
        }
    }

    fun multiplyByConstant() {
        val matrix = createMatrix("")

        println("Enter constant: ")
        val constant = getConstant()
        val result = createZeroMatrix(
            rowsNumber = matrix.size,
            columnsNumber = matrix[0].size,
        )

        for (row in 0 until matrix.size) {
            for (item in 0 until matrix[0].size) {
                result[row][item] = constant * matrix[row][item]
            }
        }

        println("The result is:")
        printMatrix(result)
        println()
    }

    fun transposeByMainDiagonal() {
        val matrix = createMatrix("")
        val result = createZeroMatrix(rowsNumber = matrix.size, columnsNumber = matrix.size)

        for (row in 0 until matrix.size) {
            for (item in 0 until matrix[0].size) {
                result[row][item] = matrix[item][row]
            }
        }

        println("The result is:")
        printMatrix(result)
        println()
    }

    private fun getRow(): ArrayList<Double> = readln().split(" ").map { it.toDouble() } as ArrayList<Double>

    private fun getConstant(): Float = readln().toFloat()

    private fun isMatrixAddable(A: Matrix, B: Matrix): Boolean {
        val aMatrixRowNumber = A.size
        val bMatrixRowNumber = B.size
        val aMatrixColumn = A[0].size
        val bMatrixColumn = B[0].size

        return aMatrixRowNumber == bMatrixRowNumber && aMatrixColumn == bMatrixColumn
    }

    private fun isMatrixMultipliable(A: Matrix, B: Matrix): Boolean {
        val bMatrixRowNumber = B.size
        val aMatrixColumn = A[0].size

        return aMatrixColumn == bMatrixRowNumber
    }

    private fun printMatrix(matrix: Matrix) {
        for (row in matrix) {
            for (index in 0 until row.size) {
                print("${row[index]} ")
                if (index == row.lastIndex) println()
            }
        }
    }

    private fun String.convertToDigitArray(): ArrayList<Int> {
        val digitArray = arrayListOf<Int>()

        for (char in this) {
            if (char != ' ') digitArray.add(char.digitToInt())
        }

        return digitArray
    }
}

