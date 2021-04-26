package demo.tasks.classloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{

    private static final String FILE_PATH = "week-01-jvm-files/task-2-classloader/Hello.xlass";
    private static final String CLASS_NAME = "Hello";
    private static final String METHOD_NAME = "hello";
    private static final int MOD_NUM = 255;

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(FILE_PATH);
        byte[] bytes = Files.readAllBytes(path);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (MOD_NUM - bytes[i]);
        }
        try {
            Class<?> helloClass = new MyClassLoader().findClass(CLASS_NAME, bytes);
            Method method = helloClass.getMethod(METHOD_NAME);
            Object instance =  helloClass.getDeclaredConstructor().newInstance();
            method.invoke(instance);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | InstantiationException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    protected Class<?> findClass(String name, byte[] bytes) throws ClassNotFoundException {
        return defineClass(name, bytes, 0, bytes.length);
    }
}
