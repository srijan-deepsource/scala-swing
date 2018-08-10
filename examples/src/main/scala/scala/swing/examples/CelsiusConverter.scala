/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2007-2014, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.swing.examples

import scala.swing._
import scala.swing.event._

/**
 * A GUI app to convert celsius to centigrade
 */
object CelsiusConverter extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Convert Celsius to Fahrenheit"
    val tempCelsius = new TextField
    val celsiusLabel = new Label {
      text = "Celsius"
      border = Swing.EmptyBorder(5, 5, 5, 5)
    }
    val convertButton = new Button {
      text = "Convert" //new javax.swing.ImageIcon("c:\\workspace\\gui\\images\\convert.gif")
      //border = Border.Empty(5, 5, 5, 5)
    }
    val fahrenheitLabel = new Label {
      text = "Fahrenheit     "
      border = Swing.EmptyBorder(5, 5, 5, 5)
      listenTo(convertButton, tempCelsius)

      def convert(): Unit = {
        val c = Integer.parseInt(tempCelsius.text)
        val f = c * 9 / 5 + 32
        text = "<html><font color = red>" + f + "</font> Fahrenheit</html>"
      }

      reactions += {
        case ButtonClicked(_) | EditDone(_) => convert()
      }
    }
    contents = new GridPanel(2, 2) {
      contents.append(tempCelsius, celsiusLabel, convertButton, fahrenheitLabel)
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }
    //defaultButton = Some(convertButton)
  }
}

