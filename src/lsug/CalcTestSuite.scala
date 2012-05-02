package lsug

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class CalcTestSuite extends FunSuite with ShouldMatchers {
  test("simple") {
//    assert( Main.calc("1 + 2") == 3 )
    Main.calc("1") should be( 1 )
    Main.calc("-1") should be( -1 )
    Main.calc("10") should be (10)
    Main.calc("a") should  be (999)
    
  }

  test("add") {
    Main.calc("1 + 4") should be( 5 )
  			
  }
  
   test("subtract") {
    Main.calc("4 - 1") should be( 3 )
    Main.calc("1 - 4") should be ( -3 )
  			
  }
   
   test("mult") {
     Main.calc("3 * 4") should be (12)
   }
   
   test("compExpr") {
     Main.calc("3 + 4 * 5") should be (23)
   }
   
   test("compExpr2") {
     Main.calc("(3 + 4) * 5") should be (35)
   }
   
   test("float"){
     Main.calc("1.5 * 4") should be (6)
   }
   
  
}