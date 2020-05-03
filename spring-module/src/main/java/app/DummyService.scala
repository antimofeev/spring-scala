package app

import org.springframework.stereotype.Service

@Service
class DummyService {
   val message: String = DummyService.inst.getMessage
}

object DummyService {

  private val inst = new CoreModule
}