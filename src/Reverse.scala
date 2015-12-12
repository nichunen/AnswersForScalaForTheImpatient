/**
 * Created by mac on 15/12/11.
 */
object Reverse extends App{
  if(args.length >= 2){
    for(i <- 0 until args.length){
      print(args(args.length - 1 - i) + " ")
    }
    println()
  }
  else if(args.length == 1){
    println(args(0))
  }
}
