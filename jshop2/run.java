import JSHOP2.*;
import java.util.*;
import java.lang.reflect.*;

public class run{
	public static void main(String[] args) {
		/*ClassLoader classloader = run.class.getClassLoader();
		try {
			Class aClass = classloader.loadClass(args[0]);
			java.lang.reflect.Method method = aClass.getMethod("getPlans");
			Object o = method.invoke(null);
			java.util.List l = ((java.util.List)o);
			System.out.println(l.size()+" plans found!");
			System.out.println(o);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	long startTime = System.currentTimeMillis();
		Object o = problem.getPlans();
    	long endTime   = System.currentTimeMillis();
    	long totalTime = endTime - startTime;
    	
    	java.util.List l = ((java.util.List)o);
		System.out.println(l.size()+" plans found!");
		System.out.println("Milis: " + totalTime);
		System.out.println(o);
	}
}
