package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation_dynamique {
    IMetier metier;

    public static void main(String[] a) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(new File("C:\\Users\\admin\\IdeaProjects\\TPIOC\\src\\main\\java\\config.txt"));
        String daoClassName= scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao)cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class mClass = Class.forName(metierClassName);
        IMetier metier = (IMetier) mClass.newInstance();

        Method m = mClass.getMethod("setDao",IDao.class);
        m.invoke(metier,dao);

        System.out.println(metier.calcul());


    }
}
