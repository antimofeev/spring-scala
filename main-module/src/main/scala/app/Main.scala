package app

object Main extends App {
  val core = new CoreModule
  val appl = new Application
  val spr = new SpringModule
  val akk = new AkkaModule

  println(appl.getMessage)
  println(core.getMessage)
  println(spr.getMessage)
  println(akk.getMessage)
}
