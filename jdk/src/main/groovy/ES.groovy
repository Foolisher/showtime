import org.junit.Test

/**
 * Desc: 
 * Created by wanggen on 2015-12-09 上午9:31.
 */



class ES {

    @Test
    public void test1(){

    }

    public static void main(String[] args){

        def shell = new GroovyShell();

        def start = System.currentTimeMillis()

        for(int i=1;i<=100;i++){

        def value = shell.evaluate("""

class ESA {
    public static double add(int a, int b){
        return a+b
    }
}

return ESA.add(100,120)

""")

        }

        println System.currentTimeMillis()-start

    }

}
