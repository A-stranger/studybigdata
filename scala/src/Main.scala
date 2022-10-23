import scala.io.Source

object Main{

  def main(args: Array[String]): Unit ={

    // 读取文件，输出每行的字符数 + 空格 + 行内容
    if (args.length>0){
      for (line <- Source.fromFile(args(0)).getLines()){
        println(line.length + " " + line)
      }
    }
    else
      Console.err.println("Please enter filename")

    // 读取整个文件，
    val lines = Source.fromFile(args(0)).getLines().toList
    def widthOfLength(s:String) = s.length.toString.length

    var maxWidth = 0
    for (line <- lines)
      maxWidth = maxWidth.max(widthOfLength(line))

    println(maxWidth)

    Traversable
  }
}
