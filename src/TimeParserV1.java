//
//public class TimeParserV1 implements TimeParser
//{
//  public Times parse(String text)
//  {
//    text = text.trim();
//    DayNight dayAndNight = DayNight.getLecturTime(text.substring(0, 2));
//    text = text.substring(2);
//    Times result = new Times(text, dayAndNight);
//    if (dayAndNight == DayNight.DAY)
//      for (String s : text.split("\\)")) {
//        s = s.trim();
//        String[] t = s.split("\\(");
//        if ((t.length == 2) && (t[0].length() > 0))
//        {
//          Time time = new Time();
//          time.week = Week.parse(t[0].substring(0, 1));
//          String[] period = t[1].split("-");
//          String[] t1 = period[0].split(":");
//          time.periodStart = ((Integer.parseInt(t1[0]) - 9) * 2);
//          time.periodStart += (Integer.parseInt(t1[1]) == 0 ? 0 : 1);
//
//          String[] t2 = period[1].split(":");
//          time.periodEnd = ((Integer.parseInt(t2[0]) - 9) * 2);
//          time.periodEnd += (Integer.parseInt(t2[1]) <= 15 ? 1 : 2);
//          time.original = (s + ")");
//          result.add(time);
//        }
//        else if (!result.isEmpty()) {
//          ((Time)result.get(result.size() - 1)).location = t[1];
//        }
//      }
//    else if (dayAndNight == DayNight.NIGHT) {
//      for (String s : text.split("\\)")) {
//        s = s.trim();
//        String[] t = s.split("\\(");
//        if ((t.length == 2) && (t[0].length() > 0))
//        {
//          Time time = new Time();
//          time.week = Week.parse(t[0].substring(0, 1));
//
//          String[] period = t[0].substring(1).split("-");
//
//          time.periodStart = Integer.parseInt(period[0]);
//          if (period.length == 1)
//            time.periodEnd = time.periodStart;
//          else {
//            time.periodEnd = Integer.parseInt(period[1]);
//          }
//          time.original = (s + ")");
//          result.add(time);
//        }
//        else if (!result.isEmpty()) {
//          ((Time)result.get(result.size() - 1)).location = t[1];
//        }
//
//      }
//
//    }
//
//    return result;
//  }
//
//  public static void main(String[] args) {
//    TimeParser parser = new TimeParserV1();
//    for (Time t : parser.parse("화2(10:00-10:50)(1공205) 금6-7(14:00-15:50)(1공205)")) {
//      System.out.println(t);
//    }
//    System.out.println();
//  }
//}