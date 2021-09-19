package se.beatit;

public class Main {

    public static void main(String[] args) {
        Object o = "ABC";
        Point p = new Point(1,2);
        var a = "A var String";

        new Test().test(o);
        new Test().test(p);
        new Test().test(a);

        // Text blocks java15
        String longs = """
                This is a long
                long string on
                multiple lines
                """;

        System.out.println(longs);
    }

    final static class Test {

        public void test(Object o) {

            // Pattern matching for instanceof java16
            if (o instanceof String s) {
                System.out.println("Wow object " + o + " casted to string " + s);
            } else if (o instanceof Point p) {
                System.out.println("Wow object " + p + " casted to point " + p);
            }
        }

        // Switch returning value using yield java 14
        public String newSwitch(String s) {
            return switch (s) {
                case "a":
                    yield "String was a";
                default:
                    yield "Something else";
            };
        }

        // Switch returning value using arrow java 14
        public String newSwitch2(String s) {
            return switch (s) {
                case "a" -> "String was a";
                case "b" -> "String was b";
                default -> {
                    System.out.println("bla bla and yield to return");
                    yield "Something else";
                }
            };
        }
    }

    // Record java16
    record Point(int x, int y) {
        public String toString() {
            return "Point " +  x + " " + y;
        }
    }
}
