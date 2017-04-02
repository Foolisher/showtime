


object T1 {

  def main(args: Array[String]) {


    // scala 版本
    val rst = Seq(
      "lee,23,hz",
      "alen,28,newyork",
      "hanm,25,beijing",
      "lei,24,beijing",
      "silen,27,")
      .map(line => line.split(","))
      .filter(line => line.length == 3 && line(2).nonEmpty)
      .groupBy(l => l(2)).map(row => {
      (row._1, row._2.foldLeft(0)((a, arr) => arr(1).toInt + a))
    })


    println(rst)


  }

}