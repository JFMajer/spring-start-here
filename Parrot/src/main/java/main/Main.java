package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);

        Parrot p4 = context.getBean(Parrot.class);
        System.out.println(p4.getName());

        Parrot p5 = new Parrot("Kiki5");
        Supplier<Parrot> supplier = () -> p5;
        context.registerBean("parrot5", Parrot.class, supplier);
        Parrot p6 = context.getBean(Parrot.class);
        System.out.println(p6.getName());

    }
}
