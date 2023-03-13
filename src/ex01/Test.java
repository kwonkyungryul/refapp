package ex01;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Package[] ps = Package.getPackages();
        String packageName = "";
        for (Package package1 : ps) {
            System.out.println(package1);
            // System.out.println(package1);
            if (package1.getName().equals("ex01")) {
                Package ex01 = package1;
                packageName = package1.getName();
                // System.out.println(packageName);
            }
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(packageName.replace(".", "/"));
        List<Class<?>> classes = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.toURI());
            if (directory.exists()) {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                        Class<?> clazz = Class.forName(className);
                        classes.add(clazz);
                        System.out.println(classes.get(0));
                    }
                }
            }
        }
    }
}
