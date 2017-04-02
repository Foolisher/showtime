import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl


class Hello {

  static void main(String[] args) {
    def binding = new Binding()
    binding.setVariable("name", "王根")
    binding.setVariable("age", 23)
    def val = eval(new GroovyScriptEngineImpl(), "return new jdk.klass.UserService()", binding);
    print(val)


  }

}
