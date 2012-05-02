package lsug

import scala.util.parsing.combinator.JavaTokenParsers
import scala.util.parsing.combinator.RegexParsers

object Main extends JavaTokenParsers  { // JavaTokenParsers {

  //val number = "[0-9]+".r
  def expr: Parser[Double] = term ~ opt( ("+" | "-") ~ expr ) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t + e
    case t ~ Some("-" ~ e) => t - e
  }
  
  def term: Parser[Double] = factor ~ rep( "*" ~ factor) ^^ {
   case f1 ~ f2 => f1 * f2.map(_._2).product 
  }
  
  def factor: Parser[Double] = floatingPointNumber ^^ { _.toDouble} | "(" ~ expr ~ ")" ^^ {
    case  _ ~ e ~ _ => e
  }
  
  def calc(s:String): Double = {
    val r = parseAll( expr, s)
    r.getOrElse(999.0)
  }
}