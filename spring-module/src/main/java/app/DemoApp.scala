package app

import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@SpringBootApplication(scanBasePackages = Array("app"))
class DemoApp

object DemoApp extends App {

  SpringApplication.run(classOf[DemoApp])
}

@RestController
class MainController @Autowired()(
                                   dummyService: DummyService
                                 ) {
  @GetMapping(Array("/scala"))
  def home: String = dummyService.message

  @PostConstruct
  def postConstruct(): Unit = {
    println("SCALA Init")
  }
}