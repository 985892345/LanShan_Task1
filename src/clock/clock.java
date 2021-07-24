package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class clock {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d, HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("是否采用当前时间？输入\"y\"表示确定，输入其他表示自定义时间");
        Scanner a = new Scanner(System.in);
        String s = a.next();
        Calendar calendar = Calendar.getInstance();
        if (!s.equals("y")) {
            int year = inputYear(a);
            int month = inputMonth(a);
            int day = inputDay(a);
            int hour = inputHour(a);
            int minute = inputMinute(a);
            int second = inputSecond(a);
            calendar.set(year, month - 1, day, hour, minute, second);
        }
        run(calendar);
    }

    private static void run(Calendar calendar) {
        printTime(calendar);
        while (true) {
            try {
                Thread.sleep(1000);
                calendar.add(Calendar.SECOND, 1);
                printTime(calendar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printTime(Calendar calendar) {
        System.out.println(sdf.format(calendar.getTime()));
    }

    private static int inputYear(Scanner a) {
        System.out.println("请输入年份：");
        int year = a.nextInt();
        while (year <= 0) {
            System.out.println("输入错误，请重新输入年份：");
            year = a.nextInt();
        }
        return year;
    }

    private static int inputMonth(Scanner a) {
        System.out.println("请输入月份：");
        int month = a.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("输入错误，请重新输入月份：");
            month = a.nextInt();
        }
        return month;
    }

    private static int inputDay(Scanner a) {
        System.out.println("请输入号数：");
        int day = a.nextInt();
        while (day < 1 || day > 31) {
            System.out.println("输入错误，请重新输入号数：");
            day = a.nextInt();
        }
        return day;
    }

    private static int inputHour(Scanner a) {
        System.out.println("请输入小时：");
        int hour = a.nextInt();
        while (hour < 1 || hour > 23) {
            System.out.println("输入错误，请重新输入小时：");
            hour = a.nextInt();
        }
        return hour;
    }

    private static int inputMinute(Scanner a) {
        System.out.println("请输入分钟：");
        int minute = a.nextInt();
        while (minute < 1 || minute > 59) {
            System.out.println("输入错误，请重新输入分钟：");
            minute = a.nextInt();
        }
        return minute;
    }

    private static int inputSecond(Scanner a) {
        System.out.println("请输入秒数：");
        int second = a.nextInt();
        while (second < 1 || second > 59) {
            System.out.println("输入错误，请重新输入秒数：");
            second = a.nextInt();
        }
        return second;
    }
}
