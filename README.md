# SeleniumWebdriver
Projeto feito no curso da udemy


public class MiniTest extends TestCase{

@Test
public void test(){
    System.out.println("Running test");
}

public static void main(String[] args){
    JUnitCore core = new JUnitCore();
    core.run(MiniTest.class);
}
