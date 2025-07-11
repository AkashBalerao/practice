import java.util.Scanner;

class Calculator
{
    static Scanner sc = new Scanner(System.in);

    enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;
        public <T extends Number> double cal(T a, T b)
        {
            switch (this) {
                case ADD:
                    return a.doubleValue() + b.doubleValue();
                case SUBTRACT:
                    return a.doubleValue() - b.doubleValue();
                case MULTIPLY:
                    return a.doubleValue() * b.doubleValue();
                case DIVIDE:
                    return a.doubleValue() / b.doubleValue();
                default:
                    throw new AssertionError("Invalid Operation" + this);
            }
        }
    }
    public static void main(String [] args)
    {
        System.out.println("Enter first number");
        double first = sc.nextDouble();
        System.out.println("Type the operation you want to perform (ADD, SUBTRACT, MULTIPLY, DIVIDE)");
        String oprn = sc.next().toUpperCase();
        System.out.println("Enter second number");
        double second = sc.nextDouble();

        double l = Operation.ADD.cal(first, second);

        try{
            Operation op = Operation.valueOf(oprn);
            System.out.println("ANSWER: "+op.cal(first, second));
        }catch(Exception e)
        {
            System.out.println("Invalid Operation");
        }   
    }
}