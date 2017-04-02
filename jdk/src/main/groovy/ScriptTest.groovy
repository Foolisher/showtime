import org.apache.ibatis.ognl.Ognl
import org.apache.ibatis.scripting.xmltags.OgnlCache
import org.junit.Test


class ScriptTest {

  @Test
  void test1() {
    println("this method test1")
  }

  static void main(String[] args) {

    def shell = new GroovyShell();

    def script = """

class ESA {
    static int add(int a, int b){
        return a+b
    }
}

return ESA.add(a,b)

"""

    def start = System.currentTimeMillis()
    shell.setVariable("a", 1)
    shell.setVariable("b", 2)
    shell.evaluate(script)
    for (int i = 1; i <= 10; i++) {
      shell.setVariable("a", 1)
      shell.setVariable("b", 2)
      def value = shell.evaluate(script)
    }
    printf("%20s %s\n", "direct script: ", (System.currentTimeMillis() - start))


    def script1 = shell.parse(script)
    script1.binding.setVariable("a", 1)
    script1.binding.setVariable("b", 2)


    start = System.currentTimeMillis()
    shell.evaluate(script)
    for (int i = 1; i <= 10000; i++) {
      script1.binding.setVariable("a", 1)
      script1.binding.setVariable("b", 2)
      def run = script1.run()
    }
    printf("%20s %s\n", "pre compile: ", (System.currentTimeMillis() - start))


    start = System.currentTimeMillis()
    for (int i = 1; i <= 10000; i++) {
      1 + 2
    }
    printf("%20s %s\n", "Java exp: ", (System.currentTimeMillis() - start))

    start = System.currentTimeMillis()
    OgnlCache.getValue("a+b", new HashMap() {
      {
        put("a", 1)
        put("b", 2)
      }
    })
    printf("%20s %s\n", "OGNL cache: ", (System.currentTimeMillis() - start))


  }

}
