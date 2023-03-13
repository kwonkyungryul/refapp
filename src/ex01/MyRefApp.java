package ex01;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MyRefApp {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        String path = "/userInfo";

        // path = "login" -> uc.login();
        // path = "join" -> uc.join();

        // 1. 컴포넌트 스캔
        // 스캔하고 2개 찾으면 2개 전부의 메서드 다 분석.

        /*  */
        // Package[] ps = Package.getPackages();
        // String packageName = "";
        // for (Package package1 : ps) {
        //     System.out.println(package1);
        //     if (package1.getName().equals("ex01")) {
        //         Package ex01 = package1;
        //         packageName = package1.getName();
        //     }
        // }

        // ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // Enumeration<URL> resources = classLoader.getResources(packageName.replace(".", "/"));
        // List<Class<?>> classes = new ArrayList<>();
        // while (resources.hasMoreElements()) {
        //     URL resource = resources.nextElement();
        //     File directory = new File(resource.toURI());
        //     if (directory.exists()) {
        //         File[] files = directory.listFiles();
        //         for (File file : files) {
        //             if (file.getName().endsWith(".class")) {
        //                 String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
        //                 Class<?> clazz = Class.forName(className);
        //                 classes.add(clazz);
        //             }
        //         }
        //     }
        // }

        // for (Class<?> class1 : classes) {
        //     if(class1.isAnnotationPresent(Controller.class)) {
        //         Method[] methods = class1.getClass().getDeclaredMethods();
                
        //         for (Method mt : methods) {
        //             Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
        //             if(anno == null) {
        //                 System.out.println("못찾음");
        //             }else {
        //                 RequestMapping rm = (RequestMapping) anno;
                        
        //                 if(rm.uri().equals(path)) {
        //                     mt.invoke(class1.newInstance());
        //                 }
        //             }
        //         }
        //     }
        // }

        /*  */

        // 2. Dispatcher 매핑

        // if (path.equals("/login")) {
        // uc.login();
        // } else if (path.equals("/join")) {
        // uc.join();
        // } else if (path.equals("/joinForm")) {
        // uc.joinForm();
        // }
        
        UserController uc = new UserController();


        Method[] methods = uc.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method mt = methods[i];
            // System.out.println(mt.getName());

            Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);

            RequestMapping rm = (RequestMapping) anno;
            System.out.println(rm.uri());

            if (rm.uri().equals(path)) {
                mt.invoke(uc);
            }
        }
    }
}
