import scala.io.StdIn.readLine

object NumberCategorizer {

  def main(args: Array[String]): Unit = {
    // Prompt the user for input
    println("Please enter an integer:")

    // Read the input from the user as a string and convert it to an integer
    val input = readLine().toInt

    // Define lambda functions for the conditions
    val isMultipleOfThree: Int => Boolean = num => num % 3 == 0
    val isMultipleOfFive: Int => Boolean = num => num % 5 == 0

    // Use pattern matching to categorize the number
    val result = (isMultipleOfThree(input), isMultipleOfFive(input)) match {
      case (true, true)  => "Multiple of Both Three and Five"
      case (true, false) => "Multiple of Three"
      case (false, true) => "Multiple of Five"
      case _             => "Not a Multiple of Three or Five"
    }

    // Print the result
    println(result)
  }
}
