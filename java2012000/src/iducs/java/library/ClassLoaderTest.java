package iducs.java.library;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        System.out.println("3 Default ClassLoader\n");
        // Bootstrap ClassLoader 확인
        final ClassLoader bootStrapClassLoader = String.class.getClassLoader();
        System.out.println("Bootstrap Classloader - ClassLoader of String.class: " + bootStrapClassLoader);

        // Platform ClassLoader 확인
        final ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println("Platform Classloader - ClassLoader.getPlatformClassLoader(): " + platformClassLoader);

        // System ClassLoader 확인
        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("System Classloader - ClassLoader.getSystemClassLoader()    : " + systemClassLoader);

        System.out.println("-----------------------------------");
        System.out.println("ClassLoader Hierarchy\n");

        System.out.println("BootStrap ClassLoader           : " + bootStrapClassLoader);
        System.out.println("platformClassLoader.getParent() : " + platformClassLoader.getParent());

        System.out.println("Platform ClassLoader             : " + platformClassLoader);
        System.out.println("systemClassLoader.getParent()    : " + systemClassLoader.getParent());


        // 외부 폴더에 있는 파일 존재 확인
        final File classRepo = new File("D:/Temp/class-repo/");
//        System.out.println(classRepo.exists());
        final File abcClassFile = new File("D:/Temp/class-repo", "iducs/java/library/External.class");
//        System.out.println(abcClassFile.exists());

        try {

            System.out.println("-----------------------------------");
            System.out.println("ClassLoader for External and Internal\n");
            final URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{ classRepo.toURI().toURL() });
            final Class<?> externalFromUrl = urlClassLoader.loadClass("iducs.java.library");
            System.out.println("ClassLoader of External: " + externalFromUrl.getClassLoader());
            System.out.println("ClassLoader of Internal: " + Internal.class.getClassLoader());

            System.out.println("-----------------------------------");

        } catch (MalformedURLException e) {
            throw new RuntimeException("URL 형식이 잘못되었습니다.", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("클래스가 없습니다.", e);
        }
    }
}