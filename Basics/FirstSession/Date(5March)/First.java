
class First{
    public static void main(String [] args)
    {
        System.out.println("Data types");
        int count = 5000;
        byte cgpa = 8;
        short age = 32;
        long phoneNumber = 7680060358L;
        float point = 43.5f;
        double cash = 847343.5323D;
        boolean f = false;

        System.out.println("count "+ count);
        System.out.println("cgpa "+ cgpa);
        System.out.println("age "+ age);
        System.out.println("phoneNumber "+ phoneNumber);
        System.out.println("point "+ point);
        System.out.println("cash "+ cash);
        System.out.println("f "+ f);

        System.out.println("------------------");
        System.out.println("Autoboxing");
        Integer a = 53;
        System.out.println(a instanceof Integer);

        System.out.println("------------------");
        System.out.println("unboxing");
        Integer a2 = 32;
        System.out.println(a2 instanceof Integer);
        int b2 = a2;
        System.out.println(b2);
        
    }
}